package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.Customer;
import com.example.assignment_java5.repository.CustomerRepository;
import com.example.assignment_java5.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer detail(Integer id) {
        return customerRepository.getById(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
