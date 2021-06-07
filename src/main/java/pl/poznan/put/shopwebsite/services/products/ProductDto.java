package pl.poznan.put.shopwebsite.services.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String extendedDescription;

    private Long quantity;
    private BigDecimal price;
    private BigDecimal total;

}
