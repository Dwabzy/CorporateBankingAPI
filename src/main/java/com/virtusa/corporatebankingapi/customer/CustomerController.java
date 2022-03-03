package com.virtusa.corporatebankingapi.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CustomerController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/customer")
    public Customer customer(@RequestParam(value="salary", defaultValue = "20000") long salary,
                             @RequestParam(value="customerName", defaultValue = "Bob") String customerName,
                             @RequestParam(value="customerEmail", defaultValue = "bob@gmail.com") String customerEmail,
                            @RequestParam(value="customerPanNumber", defaultValue = "1A2B3C") String customerPanNumber) {
        return new Customer(counter.incrementAndGet(), customerName, customerEmail, customerPanNumber, salary);
    }
}
