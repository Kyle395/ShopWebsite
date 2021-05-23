package pl.poznan.put.shopwebsite.services.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {
    private Long id;
    private Date createdAt;

    private List<ProductDto> products;
    private double total;
}
