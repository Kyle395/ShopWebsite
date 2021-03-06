package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.entities.Category;
import pl.poznan.put.shopwebsite.entities.SubCategory;
import pl.poznan.put.shopwebsite.repositories.CategoryRepository;
import pl.poznan.put.shopwebsite.repositories.SubCategoryRepository;
import pl.poznan.put.shopwebsite.services.category.SubCategoryDto;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Transactional
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    public List<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Transactional
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.getOne(id);
    }

    @Transactional
    public Map<String, List<SubCategoryDto>> getAllCategories() {
        return subCategoryRepository.findAll().stream()
                .sorted(Comparator.comparing((SubCategory subCategory) -> subCategory.getCategoryId().getName())
                        .thenComparing(SubCategory::getName))
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
