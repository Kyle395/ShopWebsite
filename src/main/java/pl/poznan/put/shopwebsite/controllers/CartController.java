package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.poznan.put.shopwebsite.services.CartService;
import pl.poznan.put.shopwebsite.services.products.ProductDto;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public void addToCart(HttpSession session,
                          @RequestParam Long id,
                          @RequestParam Integer quantity) {
        cartService.addToCart(session, id, quantity);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDto> getCart(HttpSession session) {
        return cartService.getCart(session);
    }

    @RequestMapping(value = "change", method = RequestMethod.POST)
    @ResponseBody
    public void changeQuantityInCart(HttpSession session,
                          @RequestParam Long id,
                          @RequestParam Integer quantity) {
        cartService.changeQuantityInCart(session, id, quantity);
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    @ResponseBody
    public void removeFromCart(HttpSession session,
                               @RequestParam Long id) {
        cartService.removeFromCart(session, id);
    }

}
