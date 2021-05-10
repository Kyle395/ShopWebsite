package pl.poznan.put.shopwebsite.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter @Setter @EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_login")
    private Customer customerLogin;

}
