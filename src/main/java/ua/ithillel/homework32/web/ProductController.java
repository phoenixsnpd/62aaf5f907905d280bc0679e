package ua.ithillel.homework32.web;

import org.springframework.web.bind.annotation.*;
import ua.ithillel.homework32.entity.Product;
import ua.ithillel.homework32.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable long id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping(path = "/add")
    public void add(Product product) {
        productRepository.save(product);
    }

    @PostMapping(path = "/delete/{id}")
    public void deleteProduct(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}
