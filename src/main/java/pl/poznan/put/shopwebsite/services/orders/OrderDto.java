package pl.poznan.put.shopwebsite.services.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Date createdAt;
    private double total;
}
