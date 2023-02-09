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

    @GetMapping(path = "/{id}")
    public Order findByID(@PathVariable long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/all")
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @PostMapping(path = "/{id}")
    public void deleteByid(@PathVariable long id) {
        orderRepository.deleteById(id);
    }
}
