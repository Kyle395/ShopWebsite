package pl.poznan.put.shopwebsite.services.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String createdAt;
    private BigDecimal total;
}
