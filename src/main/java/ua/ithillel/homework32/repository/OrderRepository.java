package ua.ithillel.homework32.repository;

import org.springframework.stereotype.Component;
import ua.ithillel.homework32.entity.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public OrderRepository() {
        Order order1 = new Order(1, new Date(), 100);
        Order order2 = new Order(2, new Date(), 200);
        Order order3 = new Order(3, new Date(), 300);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }

    public Optional<Order> getOrderByID(long id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findAny();
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
