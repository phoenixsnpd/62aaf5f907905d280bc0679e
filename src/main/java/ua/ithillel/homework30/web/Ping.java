package ua.ithillel.homework30.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ping {
    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }
}
