package pl.poznan.put.shopwebsite.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private BigDecimal price;

}
