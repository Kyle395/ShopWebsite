package pl.poznan.put.shopwebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.shopwebsite.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
