package ua.ithillel.homework29.entity;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    long id;

    String name;
    List<Product> products = new ArrayList<>();
}
