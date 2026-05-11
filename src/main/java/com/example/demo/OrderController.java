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
     * Test endpoint that ALWAYS throws a NullPointerException. Used for
     * verifying Kaiad's incident-queue dedup across multiple agents
     * running the same service — both agents emit the same NPE, and
     * the server is expected to collapse them into a single error
     * group keyed by (serviceId, normalized message fingerprint).
     */
    @GetMapping("/boom")
    public String boom() {
        String nothing = "boom";
        return nothing.toUpperCase();
    }
}
