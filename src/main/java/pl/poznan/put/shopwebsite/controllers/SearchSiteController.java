package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.poznan.put.shopwebsite.Constants;
import pl.poznan.put.shopwebsite.services.CategoryService;
import pl.poznan.put.shopwebsite.services.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class SearchSiteController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/searchSite", method = RequestMethod.GET)
    public String getIndex(HttpSession session, Model model,
                           @RequestParam String searchText,
                           @RequestParam(defaultValue = "0") Integer page) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        model.addAttribute("searchText", searchText);
        model.addAttribute("currentPage", page);
        model.addAttribute("products", productService.getProductsByName(searchText, page));
        model.addAttribute("productsCount", productService.getCountByName(searchText));

        return "searchSite/searchSite";
    }

}
