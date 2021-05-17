package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.entities.Category;
import pl.poznan.put.shopwebsite.entities.SubCategory;
import pl.poznan.put.shopwebsite.repositories.CategoryRepository;
import pl.poznan.put.shopwebsite.repositories.SubCategoryRepository;

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

    public Map<String, List<String>> getAllCategories() {
        Map<String, List<String>> allCategories = new HashMap<>();

        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            List<String> subCategories = subCategoryRepository.getSubCategoryByCategoryId(category).stream()
                    .map(SubCategory::getName)
                    .collect(Collectors.toList());

            allCategories.put(category.getName(), subCategories);
        }

        return allCategories;
    }

}
