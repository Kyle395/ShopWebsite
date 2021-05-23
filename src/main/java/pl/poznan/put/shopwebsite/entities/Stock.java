package pl.poznan.put.shopwebsite.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@Getter @Setter @EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    private Long productId;

    @Column
    private Long quantity;

    @Column
    private Double price;

}
