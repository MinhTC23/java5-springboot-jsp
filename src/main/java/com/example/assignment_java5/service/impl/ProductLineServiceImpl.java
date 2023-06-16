package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.ProductLine;
import com.example.assignment_java5.repository.ProductLineRepository;
import com.example.assignment_java5.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineServiceImpl implements ProductLineService {

    @Autowired
    private ProductLineRepository productLineRepository;

    @Override
    public List<ProductLine> getAll() {
        return productLineRepository.findAll();
    }

    @Override
    public ProductLine detail(Integer id) {
        return productLineRepository.getById(id);
    }

    @Override
    public void add(ProductLine productLine) {
        productLine.setDateCreate(java.time.LocalDate.now());
        productLine.setStatus(1);
        productLineRepository.save(productLine);
    }

    @Override
    public void update(ProductLine productLine) {
        productLine.setDateCorrect(java.time.LocalDate.now());
        productLineRepository.saveAndFlush(productLine);
    }

    @Override
    public void delete(Integer id) {
        productLineRepository.deleteById(id);
    }
}
