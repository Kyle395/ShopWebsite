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
import pl.poznan.put.shopwebsite.services.products.ProductDto;

import javax.servlet.http.HttpSession;

@Controller
public class ProductSiteController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/productSite", method = RequestMethod.GET)
    public String getIndex(HttpSession session, Model model,
                           @RequestParam Long id) {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("categories", categoryService.getAllCategories());
        Constants.addLibs(model);

        ProductDto dto = productService.from(productService.getProductById(id), true);
        model.addAttribute("product", dto);

        return "productSite/productSite";
    }
}
