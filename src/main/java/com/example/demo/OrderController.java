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
     * Looks up the boom marker from the request context and returns
     * an uppercased copy. The marker is currently sourced from the
     * (uninitialized) request attribute path, which produces null and
     * surfaces an NPE when the response writer calls toUpperCase().
     */
    @GetMapping("/boom")
    public String boom() {
        String marker = lookupBoomMarker();
        return marker.toUpperCase();
    }

    private String lookupBoomMarker() {
        // TODO: wire to RequestContextHolder; returning null for now
        return null;
    }
}
