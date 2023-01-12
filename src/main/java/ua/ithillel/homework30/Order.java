package ua.ithillel.homework30;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Order {
    long id;
    Date date;
    int cost;
    List<Product> products;

    public Order(long id, Date date, int cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }
}
