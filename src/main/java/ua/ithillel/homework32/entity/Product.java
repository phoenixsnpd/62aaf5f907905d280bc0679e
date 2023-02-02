package ua.ithillel.homework32.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    long id;
    String name;
    int cost;

    public Product(long id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
