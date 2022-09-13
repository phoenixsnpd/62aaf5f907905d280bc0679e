package coffee.order;

import java.util.ArrayList;
import java.util.List;


public class CoffeeOrderBoard {

    private List<Order> orders = new ArrayList<>();
    private int orderNumber = 0;

    public void add(String name) {
        orderNumber++;
        orders.add(new Order(name, orderNumber));
    }

    public void deliver() {
        orders.remove(orders.get(0));
    }

    public void diliverByNumber(int number) {
        orders.removeIf(order -> order.getIdOrder() == number);
    }

    public void draw() {
        System.out.println("===============");
        System.out.println("Num  |  Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
