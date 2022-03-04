package com.virtusa.corporatebankingapi.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/signup")
    public @ResponseBody
    String addNewUser(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam String email,
                      @RequestParam String password,
                      @RequestParam String phoneNumber,
                      @RequestParam String address,
                      @RequestParam String city,
                      @RequestParam String state,
                      @RequestParam String zipCode) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setState(state);
        customer.setZipCode(zipCode);
        customerRepository.save(customer);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Customer> getAllUsers() {
        return customerRepository.findAll();
    }
}
