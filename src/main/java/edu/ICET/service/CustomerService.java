package edu.ICET.service;

import edu.ICET.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAll();
}
