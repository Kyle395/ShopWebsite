package pl.poznan.put.shopwebsite.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.shopwebsite.entities.Product;
import pl.poznan.put.shopwebsite.entities.SubCategory;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBySubcategoryId(SubCategory id, Pageable pageable);
    long countAllBySubcategoryId(SubCategory id);
}
