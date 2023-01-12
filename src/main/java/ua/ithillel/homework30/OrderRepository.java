package ua.ithillel.homework30;

import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@ToString
public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        Product product1 = new Product(1, "Product 1", 10);
        Product product2 = new Product(2, "Product 2", 20);
        Product product3 = new Product(3, "Product 3", 30);
        Product product4 = new Product(4, "Product 4", 40);

        List<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);

        List<Product> products2 = new ArrayList<>();
        products2.add(product2);
        products2.add(product4);
        products2.add(product3);

        List<Product> products3 = new ArrayList<>();
        products3.add(product3);
        products3.add(product1);
        products3.add(product4);

        Order order1 = new Order(1, new Date(), 100, products1);
        Order order2 = new Order(2, new Date(), 200, products2);
        Order order3 = new Order(3, new Date(), 300, products3);

        orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }

    public Order getByOrderId(long id) {
        Optional<Order> returnedOrder;
        returnedOrder = orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst();
        return returnedOrder.get();
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addProduct(Order order) {
        orders.add(order);
    }

}
