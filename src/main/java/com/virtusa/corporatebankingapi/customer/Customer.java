package com.virtusa.corporatebankingapi.customer;

public class Customer {
    private final long customerID;
    private final String customerName;
    private final String customerEmail;
    private final String customerPanNumber;
    private final long salary;

    public Customer(long customerID, String customerName, String customerEmail, String customerPanNumber, long salary) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPanNumber = customerPanNumber;
        this.salary = salary;
    }

    public long getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public String getCustomerPanNumber(){
        return customerPanNumber;
    }

    public long getSalary(){
        return salary;
    }


}
