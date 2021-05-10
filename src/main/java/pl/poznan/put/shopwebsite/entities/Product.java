package pl.poznan.put.shopwebsite.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter @Setter @EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String picture;

    @Column
    private String category;

    @Column
    private String description;

}
