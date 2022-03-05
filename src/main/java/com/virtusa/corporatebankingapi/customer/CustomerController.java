package com.virtusa.corporatebankingapi.customer;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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
                      @RequestParam String zipCode,
                      @RequestParam String dob) {

        Customer customer = new Customer(firstName, lastName, email, password, phoneNumber, address, city, state, zipCode, dob);
        customerRepository.save(customer);
        return "Saved";
    }


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Customer getUser(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);

    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    String updateUser(@PathVariable UUID id,
                      @RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam String email,
                      @RequestParam String password,
                      @RequestParam String phoneNumber,
                      @RequestParam String address,
                      @RequestParam String city,
                      @RequestParam String state,
                      @RequestParam String country,
                      @RequestParam String zipCode,
                      @RequestParam String dob,
                      Customer customer) {
        customerRepository.save(customer);
        return "Saved";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    String deleteUser(@PathVariable String id) {
        customerRepository.deleteById(id);
        return "Deleted";
    }
}