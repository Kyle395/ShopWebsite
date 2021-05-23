package pl.poznan.put.shopwebsite.services.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {
    private Long id;
    private String createdAt;

    private List<ProductDto> products;
    private BigDecimal total;
}
