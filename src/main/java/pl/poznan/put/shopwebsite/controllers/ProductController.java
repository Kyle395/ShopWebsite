package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pl.poznan.put.shopwebsite.entities.Product;
import pl.poznan.put.shopwebsite.services.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Long subcategoryId,
                             @RequestParam BigDecimal price,
                             @RequestParam MultipartFile picture) {
        Product product = productService.addProduct(name, description, subcategoryId, picture);
        productService.addStock(product.getId(), price, 1L);
        return "redirect:userSite/userSite";
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getImage(@RequestParam Long productId) throws IOException {
        Product product = productService.getProductById(productId);
        return Files.readAllBytes(Path.of(product.getPicture()));
    }

}
