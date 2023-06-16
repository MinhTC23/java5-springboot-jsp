package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category detail(Integer id);

    void add(Category category);

    void update(Category category);

    void delete(Integer id);
}
