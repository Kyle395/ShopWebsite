package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.poznan.put.shopwebsite.Constants;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.services.CategoryService;

import javax.servlet.http.HttpSession;

@Controller
public class CartSiteController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getIndex(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return "redirect:/";
        }

        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "shopCart/shopCart";
    }

}
