package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.repositories.CustomerRepository;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> login(HttpSession session,
                                     @RequestParam String login,
                                     @RequestParam String password) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer != null) {
            return Collections.singletonMap("status", "ALREADY_LOGGED_IN");
        }

        Optional<Customer> targetCustomer = customerRepository.findById(login);
        if (targetCustomer.isEmpty()) {
            return Collections.singletonMap("status", "INVALID_DATA");
        }

        customer = targetCustomer.get();

        if (!customer.getPassword().equals(password)) {
            return Collections.singletonMap("status", "INVALID_DATA");
        }

        session.setAttribute("user", customer);

        return Collections.singletonMap("status", "OK");
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> logout(HttpSession session) {
        session.removeAttribute("user");
        return Collections.singletonMap("status", "OK");
    }

}
