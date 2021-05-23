package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.entities.Product;
import pl.poznan.put.shopwebsite.repositories.ProductRepository;
import pl.poznan.put.shopwebsite.repositories.StockRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public BigDecimal getProductPrice(Product product) {
        return stockRepository.getOne(product.getId()).getPrice();
    }

}
