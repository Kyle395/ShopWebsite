package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.services.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("account")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(HttpSession session,
                                     @RequestParam String login,
                                     @RequestParam String password) {
        if (session.getAttribute("user") != null) {
            return Collections.singletonMap("status", "ALREADY_LOGGED_IN");
        }

        Optional<Customer> customer = customerService.authenticate(login, password);

        if (customer.isEmpty()) {
            return Collections.singletonMap("status", "INVALID_DATA");
        }

        session.setAttribute("user", customer.get());
        session.setAttribute("cart", new HashMap<Long, Integer>());

        return Collections.singletonMap("status", "OK");
    }

    @RequestMapping(value = "changepassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> changePassword(HttpSession session,
                                              @RequestParam String currentPassword,
                                              @RequestParam String newPassword,
                                              @RequestParam String newPasswordRepeat) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return Collections.singletonMap("status", "NOT_LOGGED_IN");
        }

        CustomerService.ChangePasswordResult result = customerService.changePassword(
                customer, currentPassword, newPassword, newPasswordRepeat
        );

        return Collections.singletonMap("status", result.toString());
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> register(@RequestParam String login,
                                        @RequestParam String newPassword,
                                        @RequestParam String newPasswordRepeat,
                                        @RequestParam String email) {
        CustomerService.RegisterResult result = customerService.register(
                login, newPassword, newPasswordRepeat, email
        );

        return Collections.singletonMap("status", result.toString());
    }

    @RequestMapping(value = "changeemail", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> changeEmail(HttpSession session,
                                           @RequestParam String currentEmail,
                                           @RequestParam String newEmail,
                                           @RequestParam String newEmailRepeat) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return Collections.singletonMap("status", "NOT_LOGGED_IN");
        }

        CustomerService.ChangeEmailResult result = customerService.changeEmail(
                customer, currentEmail, newEmail, newEmailRepeat
        );

        return Collections.singletonMap("status", result.toString());
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("cart");
        return Collections.singletonMap("status", "OK");
    }

}
