package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.poznan.put.shopwebsite.entities.Product;
import pl.poznan.put.shopwebsite.entities.Stock;
import pl.poznan.put.shopwebsite.entities.SubCategory;
import pl.poznan.put.shopwebsite.repositories.ProductRepository;
import pl.poznan.put.shopwebsite.repositories.StockRepository;
import pl.poznan.put.shopwebsite.services.products.ProductDto;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final String IMAGES_PATH = "productImages" + File.separator;
    private static final int PAGE_SIZE = 20;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private CategoryService categoryService;

    @Transactional
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

    @Transactional
    public List<ProductDto> getProductsBySubCategoryId(Long id, Integer page) {
        SubCategory subCategory = categoryService.getSubCategoryById(id);

        return productRepository.findAllBySubcategoryId(
                subCategory,
                PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Direction.ASC, "name"))
        ).stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public long getCountBySubcategoryId(Long id) {
        SubCategory subCategory = categoryService.getSubCategoryById(id);
        return productRepository.countAllBySubcategoryId(subCategory);
    }

    @Transactional
    public Product addProduct(String name, String description,
                                       Long subcategoryId, MultipartFile picture) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);

        SubCategory subCategory = categoryService.getSubCategoryById(subcategoryId);
        product.setSubcategoryId(subCategory);

        product = productRepository.saveAndFlush(product);

        try (FileOutputStream os = new FileOutputStream(IMAGES_PATH + product.getId() + ".png")) {
            os.write(picture.getBytes());
            productRepository.saveAndFlush(product);
        } catch (IOException e) {
            productRepository.delete(product);
            return null;
        }

        return product;
    }

    @Transactional
    public void addStock(Long productId, BigDecimal price, Long quantity) {
        stockRepository.save(new Stock(productId, quantity, price));
    }

    @Transactional
    public BigDecimal getProductPrice(Product product) {
        return stockRepository.getOne(product.getId()).getPrice();
    }

    @Transactional
    public Stock getStock(Product product) {
        return stockRepository.getOne(product.getId());
    }

    @Transactional
    public ProductDto from(Product product) {
        Stock stock = getStock(product);
        return new ProductDto(
            product.getId(), product.getName(), product.getDescription(),
            stock.getQuantity(), stock.getPrice()
        );
    }

    public enum AddProductResult {
        OK, ERROR
    }

}
