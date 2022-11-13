package coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;


public class CoffeeOrderBoard {
    private static final Logger log = LogManager.getLogger(CoffeeOrderBoard.class);
    private Queue<Order> orders = new ArrayDeque<>();
    private int orderNumber = 0;

    public void add(String name) {
        orderNumber++;
        orders.add(new Order(name, orderNumber));
        log.info("An order was created in the name of {} by the number {}", name, orderNumber);
    }

    public Order deliver() {
        log.info("Issued order: {}", orders.peek());
        return orders.remove();
    }

    public Order deliver(int number) {
        Order deliverOrder;
        for (Order order : orders) {
            if (order.getIdOrder() == number) {
                deliverOrder = order;
                orders.remove(order);
                log.info("Issued order: {}", order);
                return deliverOrder;
            }
        }
        log.error("The order with id: {} didn't found!", number);
        throw new RuntimeException("The order with id:" + number + " didn't found!");
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
