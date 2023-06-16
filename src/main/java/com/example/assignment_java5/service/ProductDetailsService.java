package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.ProductDetails;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductDetailsService {

    List<ProductDetails> getAll();

    ProductDetails detail(Integer id);

    void add(ProductDetails productDetails);

    void update(ProductDetails productDetails);

    void delete(Integer id);

    Page<ProductDetails> paging(Integer page, Integer size);

    void updateNumber(Integer number, Integer id);
}
