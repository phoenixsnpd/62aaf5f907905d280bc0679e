package ua.ithillel.homework32.web;

import org.springframework.web.bind.annotation.*;
import ua.ithillel.homework32.entity.Order;
import ua.ithillel.homework32.repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Order findByID(@PathVariable long id) {
        return orderRepository.getOrderByID(id).orElse(null);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Order> findAll() {
        return orderRepository.getAllOrders();
    }
}
