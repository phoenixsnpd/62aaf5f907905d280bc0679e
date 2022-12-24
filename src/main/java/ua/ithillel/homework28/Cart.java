package ua.ithillel.homework28;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Component // was service
@Scope("prototype")
public class Cart {
    List<Product> order = new ArrayList<>();

    public void add(Product product) {
        order.add(product);
    }

    public Product delete(int id) {
        Product retProd = null;
        for (Product prod : order) {
            if (prod.getId() == id) {
                retProd = prod;
            }
        }
        order.remove(retProd);
        return retProd;
    }
}
