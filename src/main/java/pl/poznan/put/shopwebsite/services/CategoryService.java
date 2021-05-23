package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.entities.Category;
import pl.poznan.put.shopwebsite.entities.SubCategory;
import pl.poznan.put.shopwebsite.repositories.CategoryRepository;
import pl.poznan.put.shopwebsite.repositories.SubCategoryRepository;
import pl.poznan.put.shopwebsite.services.category.SubCategoryDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }

    public List<SubCategory> getALlSubCategories() {
        return subCategoryRepository.findAll();
    }

    public Map<String, List<SubCategoryDto>> getAllCategories() {
        return subCategoryRepository.findAll().stream()
                .sorted(Comparator.comparing(SubCategory::getName))
                .collect(Collectors.groupingBy(
                        subCategory -> subCategory.getCategoryId().getName(),
                        LinkedHashMap::new,
                        Collectors.mapping(
                                subCategory -> new SubCategoryDto(subCategory.getId(), subCategory.getName()),
                                Collectors.toList()
                        )
                ));
    }

}
