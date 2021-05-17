package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.entities.Category;
import pl.poznan.put.shopwebsite.entities.SubCategory;
import pl.poznan.put.shopwebsite.repositories.CategoryRepository;
import pl.poznan.put.shopwebsite.repositories.SubCategoryRepository;

import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }

}
