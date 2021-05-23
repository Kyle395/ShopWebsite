package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.entities.Order;
import pl.poznan.put.shopwebsite.entities.OrderDetails;
import pl.poznan.put.shopwebsite.repositories.OrderDetailsRepository;
import pl.poznan.put.shopwebsite.repositories.OrderRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

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

}
