package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/orders/{id}")
    public String getOrder(@PathVariable String id) {
        String orderType = "standard";
        return "order " + id + " is " + orderType.toUpperCase();
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
