package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.poznan.put.shopwebsite.Constants;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.services.CategoryService;
import pl.poznan.put.shopwebsite.services.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class AddProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null || !customer.getLogin().equals("admin")) {
            return "redirect:/";
        }

        model.addAttribute("user", customer);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("product", productService.getProducts());
        Constants.addLibs(model);
        return "addProductForm/addProductForm";
    }
}
