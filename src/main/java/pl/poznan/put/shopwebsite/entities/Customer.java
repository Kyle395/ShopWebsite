package pl.poznan.put.shopwebsite.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Getter @Setter @EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String login;

    @Column
    private String password;

    @Column
    private String email;

}
