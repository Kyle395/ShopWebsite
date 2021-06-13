package pl.poznan.put.shopwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.poznan.put.shopwebsite.Constants;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.entities.Order;
import pl.poznan.put.shopwebsite.entities.OrderDetails;
import pl.poznan.put.shopwebsite.entities.Product;
import pl.poznan.put.shopwebsite.services.CartService;
import pl.poznan.put.shopwebsite.services.OrderService;
import pl.poznan.put.shopwebsite.services.ProductService;
import pl.poznan.put.shopwebsite.services.orders.OrderDetailsDto;
import pl.poznan.put.shopwebsite.services.orders.OrderDto;
import pl.poznan.put.shopwebsite.services.products.ProductDto;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("orders")
public class OrderController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderDto> getOrders(HttpSession session,
                                    @RequestParam(defaultValue = "0") Integer pageNum) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return new LinkedList<>();
        }

        List<Order> orders = orderService.getOrders(customer, PageRequest.of(
                pageNum, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "createdAt")
        ));

        return orders.stream()
                .map(order -> {
                    BigDecimal total = orderService.getOrderDetails(order).stream()
                            .map(orderDetails -> {
                                BigDecimal price = productService.getProductPrice(orderDetails.getProductId());
                                return price.multiply(BigDecimal.valueOf(orderDetails.getQuantity()));
                            })
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    return new OrderDto(
                            order.getId(),
                            Constants.DATE_FORMATTER.format(order.getCreatedAt()),
                            total
                    );
                })
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    @ResponseBody
    public void submitOrder(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return;
        }

        List<ProductDto> cart = cartService.getCart(session);

        orderService.submitOrder(customer, cart);
        cartService.clearCart(session);
    }

}
