package com.virtusa.corporatebankingapi.customer;

public class Customer {
    private final long customerID;
    private final String customerName;

    public Customer(long customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public long getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }
}
