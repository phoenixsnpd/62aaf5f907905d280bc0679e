package ua.ithillel.homework28;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Component
public class ProductRepository {
    @Autowired
    List<Product> products = new ArrayList<>();

    public Product getProductById(int productId) {
       for (Product product : products) {
           if (product.getId() == productId) {
               return product;
           }
       }
       throw new RuntimeException("Product with the specified index doesn't exist");
    }
}
