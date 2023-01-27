package ua.ithillel.homework32.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.ithillel.homework32.entity.Order;
import ua.ithillel.homework32.repository.OrderRepository;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order findByID(@PathVariable long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
