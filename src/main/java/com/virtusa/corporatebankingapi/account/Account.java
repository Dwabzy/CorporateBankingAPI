package com.virtusa.corporatebankingapi.account;

import com.virtusa.corporatebankingapi.customer.Customer;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    private long accountNumber;
    // Create a one to one mapping between Account and Customer
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;
    private double balance;
    private String accountType;
    private String bankName;
    private String branchName;
    private String ifscCode;

    public Account() {
        this.accountNumber = (long) (Math.random() * 1000000);
    }

    public Account(double balance, String accountType, String bankName, String branchName, String ifscCode) {
        this.accountNumber = (long) (Math.random() * 1000000);
        this.balance = balance;
        this.accountType = accountType;
        this.bankName = bankName;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
