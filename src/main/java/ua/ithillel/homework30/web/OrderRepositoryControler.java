package ua.ithillel.homework30.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderRepositoryControler {
    @GetMapping("/all")
    public String getAllOrders() {
        return "all";
    }

    @GetMapping("/id")
    public String getOrderbyId(@RequestParam(value = "id", required = false) long id,
                               Model model) {
        model.addAttribute("id", id);
        return "id";
    }
}
