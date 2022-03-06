package com.virtusa.corporatebankingapi.account;

import com.virtusa.corporatebankingapi.customer.CustomerRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<String> addAccount(@RequestParam String customerId,
                                      @RequestParam Double balance,
                                      @RequestParam String accountType,
                                      @RequestParam String bankName,
                                      @RequestParam String branchName,
                                      @RequestParam String ifscCode) throws ConstraintViolationException {
        try {
            Account account = new Account(balance, accountType, bankName, branchName, ifscCode);
            System.out.println(account.getAccountNumber());
            customerRepository.findById(customerId).ifPresent(account::setCustomer);
            accountRepository.save(account);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // Create new response entity with conflict status
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account already exists for Customer");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Account added successfully");
    }


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
