package pl.poznan.put.shopwebsite.entities.pk;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDetailsPK implements Serializable {
    private Long orderId;
    private Long productId;
}
