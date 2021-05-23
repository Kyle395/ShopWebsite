package pl.poznan.put.shopwebsite.repositories;

 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.shopwebsite.entities.Order;
import pl.poznan.put.shopwebsite.entities.OrderDetails;
import pl.poznan.put.shopwebsite.entities.pk.OrderDetailsPK;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsPK> {
    List<OrderDetails> findAllByOrderId(Order orderId);
}
