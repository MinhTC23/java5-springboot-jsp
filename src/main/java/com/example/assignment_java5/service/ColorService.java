package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.Color;

import java.util.List;

public interface ColorService {

    List<Color> getAll();

    Color detail(Integer id);

    void add(Color color);

    void update(Color color);

    void delete(Integer id);
}
