package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.ProductLine;

import java.util.List;

public interface ProductLineService {

    List<ProductLine> getAll();

    ProductLine detail(Integer id);

    void add(ProductLine productLine);

    void update(ProductLine productLine);

    void delete(Integer id);
}
