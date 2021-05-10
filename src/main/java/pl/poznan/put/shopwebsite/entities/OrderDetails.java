package pl.poznan.put.shopwebsite.entities;

import lombok.*;
import pl.poznan.put.shopwebsite.entities.pk.OrderDetailsPK;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@IdClass(OrderDetailsPK.class)
@Getter @Setter @EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column
    private Long quantity;

}
