package pl.poznan.put.shopwebsite.services.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;

    private double price;
    private long quantity;

    private double total;
}
