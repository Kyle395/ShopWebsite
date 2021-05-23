package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.poznan.put.shopwebsite.Constants;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.services.CategoryService;
import pl.poznan.put.shopwebsite.services.OrderService;

import javax.servlet.http.HttpSession;

@Controller
public class UserSiteController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/userSite", method = RequestMethod.GET)
    public String getUserSite(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return "redirect:/";
        }

        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "userSite/userSite";
    }

    @RequestMapping(value = "/userSite/orderDetails", method = RequestMethod.GET)
    public String getOrderDetails(HttpSession session, Model model,
                                  @RequestParam Long id) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return "redirect:/";
        }

        model.addAttribute("user", customer);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("orderDetails", orderService.getOrderDetails(customer, id));
        Constants.addLibs(model);

        return "userSite/orderDetails";
    }

    @RequestMapping(value = "/userSite/changeAddress", method = RequestMethod.GET)
    public String getAddress(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return "redirect:/";
        }

        model.addAttribute("user", customer);
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "userSite/changeAddress";
    }

    @RequestMapping(value = "/userSite/changePassword", method = RequestMethod.GET)
    public String getPassword(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return "redirect:/";
        }

        model.addAttribute("user", customer);
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "userSite/changePassword";
    }

}
