package coffee.order;

import java.util.ArrayDeque;
import java.util.Queue;


public class CoffeeOrderBoard {

    private Queue<Order> orders = new ArrayDeque<>();
    private int orderNumber = 0;

    public void add(String name) {
        orderNumber++;
        orders.add(new Order(name, orderNumber));
    }

    public Order deliver() {
        return orders.remove();
    }

    public Order deliver(int number) {
        Order deliverOrder;
        for (Order order : orders) {
            if (order.getIdOrder() == number) {
                deliverOrder = order;
                orders.remove(order);
                return deliverOrder;
            }
        }
        return deliverOrder = new Order("Empty deliver", 0);
    }

    public void draw() {
        System.out.println("===============");
        System.out.println("Num  |  Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public Queue<Order> getOrders() {
        return orders;
    }
}
