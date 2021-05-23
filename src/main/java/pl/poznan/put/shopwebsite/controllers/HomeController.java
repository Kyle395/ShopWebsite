package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.poznan.put.shopwebsite.Constants;
import pl.poznan.put.shopwebsite.services.CategoryService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "home";
    }

    @RequestMapping(value = "/userSite", method = RequestMethod.GET)
    public String getUserSite(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "userSite/userSite";
    }

    @RequestMapping(value = "/userSite/changeAddress", method = RequestMethod.GET)
    public String getAddress(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "userSite/changeAddress";
    }

    @RequestMapping(value = "/userSite/changePassword", method = RequestMethod.GET)
    public String getPassword(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        return "userSite/changePassword";
    }

}
