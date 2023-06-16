package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer detail(Integer id);

    void add(Customer customer);

    void update(Customer customer);

    void delete(Integer id);
}
