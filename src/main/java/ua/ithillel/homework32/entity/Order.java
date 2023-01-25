package ua.ithillel.homework32.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "date")
    Date date;

    @Column(name = "cost")
    int cost;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Product> products;

    public Order() {
    }
}
