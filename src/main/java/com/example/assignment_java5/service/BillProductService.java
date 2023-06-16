package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.BillProduct;

import java.util.List;

public interface BillProductService {

    void add(BillProduct billProduct);

    List<BillProduct> search(String phoneNumber);
}
