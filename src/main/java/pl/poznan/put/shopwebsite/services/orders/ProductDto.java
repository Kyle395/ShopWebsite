package pl.poznan.put.shopwebsite.services.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.poznan.put.shopwebsite.entities.Product;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private long id;
    private String name;

    private BigDecimal price;
    private long quantity;

    private BigDecimal total;
}
