package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.services.products.ProductDto;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private ProductService productService;

    public void addToCart(HttpSession session, long productId, int quantity)  {
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
        cart.putIfAbsent(productId, 0);
        cart.put(productId, cart.get(productId) + quantity);
    }

    public List<ProductDto> getCart(HttpSession session) {
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");

        List<ProductDto> products = new ArrayList<>(cart.size());

        cart.forEach((productId, quantity) -> {
            products.add(
                    productService.from(productService.getProductById(productId))
            );
        });

        products.sort(Comparator.comparing(ProductDto::getName));

        return products;
    }

    public void changeQuantityInCart(HttpSession session, long productId, int quantity)  {
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
        if (!cart.containsKey(productId)) return;

        cart.put(productId, quantity);
    }

    public void removeFromCart(HttpSession session, long productId)  {
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
        cart.remove(productId);
    }

}
