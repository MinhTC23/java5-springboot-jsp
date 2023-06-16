package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.BillProduct;
import com.example.assignment_java5.repository.BillProductRepository;
import com.example.assignment_java5.service.BillProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillProductServiceImpl implements BillProductService {

    @Autowired
    private BillProductRepository billProductRepository;

    @Override
    public void add(BillProduct billProduct) {
        billProductRepository.save(billProduct);
    }

    @Override
    public List<BillProduct> search(String phoneNumber) {
        return billProductRepository.search(phoneNumber);
    }
}
