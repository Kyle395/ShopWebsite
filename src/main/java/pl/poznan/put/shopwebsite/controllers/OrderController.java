package pl.poznan.put.shopwebsite.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.entities.Order;
import pl.poznan.put.shopwebsite.entities.OrderDetails;
import pl.poznan.put.shopwebsite.entities.Product;
import pl.poznan.put.shopwebsite.services.OrderService;
import pl.poznan.put.shopwebsite.services.ProductService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("orders")
public class OrderController {

    private static final int PAGE_SIZE = 10;

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
                    double total = orderService.getOrderDetails(order).stream()
                            .mapToDouble(orderDetails -> {
                                double price = productService.getProductPrice(orderDetails.getProductId());
                                return price * orderDetails.getQuantity();
                            })
                            .sum();

                    return new OrderDto(order.getId(), order.getCreatedAt(), total);
                })
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ResponseBody
    public OrderDetailsDto getOrderDetails(HttpSession session,
                                          @RequestParam Long id) {
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            return null;
        }

        Order order = orderService.getOrder(id);
        if (!customer.getLogin().equals(order.getCustomerLogin().getLogin())) {
            return null;
        }

        List<OrderDetails> orderDetailsList = orderService.getOrderDetails(order);

        List<ProductDto> products = orderDetailsList.stream()
                .map(orderDetails -> {
                    Product product = orderDetails.getProductId();

                    double price = productService.getProductPrice(product);
                    long quantity = orderDetails.getQuantity();

                    return new ProductDto(
                            product.getName(), price, quantity, price * quantity
                    );
                })
                .collect(Collectors.toList());

        return new OrderDetailsDto(
                order.getId(), order.getCreatedAt(), products,
                products.stream()
                    .mapToDouble(ProductDto::getTotal)
                    .sum()
        );
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class OrderDto {
        private Long id;
        private Date createdAt;
        private double total;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class OrderDetailsDto {
        private Long id;
        private Date createdAt;

        private List<ProductDto> products;
        private double total;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class ProductDto {
        private String name;

        private double price;
        private long quantity;

        private double total;
    }

}
