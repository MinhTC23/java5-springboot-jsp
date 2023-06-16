package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.ProductDetails;
import com.example.assignment_java5.repository.ProductDetailsRepository;
import com.example.assignment_java5.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public List<ProductDetails> getAll() {
        return productDetailsRepository.findAll();
    }

    @Override
    public ProductDetails detail(Integer id) {
        return productDetailsRepository.getById(id);
    }

    @Override
    public void add(ProductDetails productDetails) {
        productDetails.setStatus(1);
        productDetailsRepository.save(productDetails);
    }

    @Override
    public void update(ProductDetails productDetails) {
        productDetailsRepository.saveAndFlush(productDetails);
    }

    @Override
    public void delete(Integer id) {
        productDetailsRepository.deleteById(id);
    }

    @Override
    public Page<ProductDetails> paging(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return productDetailsRepository.findAll(pageable);
    }

    @Override
    public void updateNumber(Integer number, Integer id) {
        productDetailsRepository.updateNumber(number, id);
    }
}
