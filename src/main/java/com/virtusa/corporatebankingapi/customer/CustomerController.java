package com.virtusa.corporatebankingapi.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CustomerController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/customer")
    public Customer customer(@RequestParam(value="customerId", defaultValue = "0") String customerId,
                             @RequestParam(value="customerName", defaultValue = "Bob") String customerName) {
        return new Customer(counter.incrementAndGet(), customerName);
    }
}
