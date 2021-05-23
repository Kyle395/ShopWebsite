package pl.poznan.put.shopwebsite.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.entities.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerLogin(Customer customer, Pageable pageable);
}
