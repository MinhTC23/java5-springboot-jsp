package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.Category;
import com.example.assignment_java5.repository.CategoryRepository;
import com.example.assignment_java5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category detail(Integer id) {
        return categoryRepository.getById(id);
    }

    @Override
    public void add(Category category) {
        category.setStatus(1);
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
