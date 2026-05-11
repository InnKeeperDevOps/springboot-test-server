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

    /**
     * Renders the boom marker. The marker source is resolved from
     * the application properties; when the key is absent the lookup
     * returns null and downstream consumers must handle that.
     */
    @GetMapping("/boom")
    public String boom() {
        String marker = resolveMarker();
        return marker.trim() + "!";
    }

    private String resolveMarker() {
        // FIXME: read from spring.application.boom-marker property
        return null;
    }
}
