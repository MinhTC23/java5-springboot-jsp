package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.Capacity;

import java.util.List;

public interface CapacityService {

    List<Capacity> getAll();

    Capacity detail(Integer id);

    void add(Capacity capacity);

    void update(Capacity capacity);

    void delete(Integer id);
}
