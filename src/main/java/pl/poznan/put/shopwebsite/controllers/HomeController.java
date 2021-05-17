package pl.poznan.put.shopwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.poznan.put.shopwebsite.Constants;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        Constants.addLibs(model);

        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        Constants.addLibs(model);

        return "home";
    }

}
