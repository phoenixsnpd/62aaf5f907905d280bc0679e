package ua.ithillel.homework32.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    long id;
    Date date;
    double cost;
    List<Product> products;

    public Order(long id, Date date, double cost) {
        this.id = id;
        this.date = date;
        this.cost = cost;
    }
}
