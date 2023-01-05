package ua.ithillel.homework29.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    long id;
    String name;
    int price;
}
