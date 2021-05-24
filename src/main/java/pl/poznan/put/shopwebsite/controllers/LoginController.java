package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.repositories.CustomerRepository;
import pl.poznan.put.shopwebsite.services.CustomerService;
import pl.poznan.put.shopwebsite.services.customer.ChangePasswordResult;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("account")
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

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

        ChangePasswordResult result = customerService.changePassword(
                customer, currentPassword, newPassword, newPasswordRepeat
        );

        return Collections.singletonMap("status", result.toString());
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> logout(HttpSession session) {
        session.removeAttribute("user");
        return Collections.singletonMap("status", "OK");
    }

}
