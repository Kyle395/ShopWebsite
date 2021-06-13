package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.poznan.put.shopwebsite.Constants;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.entities.Order;
import pl.poznan.put.shopwebsite.entities.OrderDetails;
import pl.poznan.put.shopwebsite.entities.Product;
import pl.poznan.put.shopwebsite.repositories.OrderDetailsRepository;
import pl.poznan.put.shopwebsite.repositories.OrderRepository;
import pl.poznan.put.shopwebsite.services.orders.OrderDetailsDto;
import pl.poznan.put.shopwebsite.services.orders.ProductDto;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {


    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Transactional
    public List<Order> getOrders(Customer customer, Pageable pageable) {
        return orderRepository.findAllByCustomerLogin(customer, pageable);
    }

    @Transactional
    public Order getOrder(Long id) {
        return orderRepository.getOne(id);
    }

    @Transactional
    public List<OrderDetails> getOrderDetails(Order order) {
        return orderDetailsRepository.findAllByOrderId(order);
    }

    @Transactional
    public OrderDetailsDto getOrderDetails(Customer customer, Long id) {
        if (customer == null) {
            return null;
        }

        Order order = getOrder(id);
        if (!customer.getLogin().equals(order.getCustomerLogin().getLogin())) {
            return null;
        }

        List<OrderDetails> orderDetailsList = getOrderDetails(order);

        List<ProductDto> products = orderDetailsList.stream()
                .map(orderDetails -> {
                    Product product = orderDetails.getProductId();

                    BigDecimal price = productService.getProductPrice(product);
                    long quantity = orderDetails.getQuantity();

                    return new ProductDto(
                            product.getId(), product.getName(), price, quantity, price.multiply(BigDecimal.valueOf(quantity))
                    );
                })
                .collect(Collectors.toList());

        return new OrderDetailsDto(
                order.getId(), Constants.DATE_FORMATTER.format(order.getCreatedAt()), products,
                products.stream()
                        .map(ProductDto::getTotal)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }

}
