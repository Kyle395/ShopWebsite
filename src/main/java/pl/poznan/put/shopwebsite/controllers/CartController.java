package pl.poznan.put.shopwebsite.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.poznan.put.shopwebsite.services.CartService;
import pl.poznan.put.shopwebsite.services.products.ProductDto;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
        if (session.getAttribute("user") == null) return;
        cartService.addToCart(session, id, quantity);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public CartDto getCart(HttpSession session) {
        if (session.getAttribute("user") == null) return null;

        List<ProductDto> cart = cartService.getCart(session);
        BigDecimal total = cart.stream()
                .reduce(BigDecimal.ZERO,
                        (current, product) -> current.add(product.getTotal()),
                        BigDecimal::add);
        return new CartDto(cart, total);
    }

    @RequestMapping(value = "change", method = RequestMethod.POST)
    @ResponseBody
    public void changeQuantityInCart(HttpSession session,
                          @RequestParam Long id,
                          @RequestParam Integer quantity) {
        if (session.getAttribute("user") == null) return;
        cartService.changeQuantityInCart(session, id, quantity);
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    @ResponseBody
    public void removeFromCart(HttpSession session,
                               @RequestParam Long id) {
        if (session.getAttribute("user") == null) return;
        cartService.removeFromCart(session, id);
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @AllArgsConstructor
    private static class CartDto {
        private List<ProductDto> cartList;
        private BigDecimal total;
    }

}
