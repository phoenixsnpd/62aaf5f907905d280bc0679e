package ua.ithillel.homework28;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductRepositoryConfig {
    @Bean
    public List<Product> product() {
        List<Product> result = new ArrayList<>();
        result.add(new Product(1, "Desk", 200));
        result.add(new Product(2, "Pencil", 2));
        result.add(new Product(3, "Book", 20));
        return result;
    }

}
