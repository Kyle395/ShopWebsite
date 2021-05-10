package pl.poznan.put.shopwebsite.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter @Setter @EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "customer_login")
    private Customer customerLogin;

    @Column
    private String content;

    @Column
    private Double rating;

}
