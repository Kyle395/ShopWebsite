package pl.poznan.put.shopwebsite.services.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class SubCategoryDto {
    private Long id;
    private String name;
}
