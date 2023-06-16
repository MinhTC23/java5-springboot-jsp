package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.Color;
import com.example.assignment_java5.repository.ColorRepository;
import com.example.assignment_java5.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public Color detail(Integer id) {
        return colorRepository.getById(id);
    }

    @Override
    public void add(Color color) {
        color.setDateCreate(java.time.LocalDate.now());
        color.setStatus(1);
        colorRepository.save(color);
    }

    @Override
    public void update(Color color) {
        color.setDateCorrect(java.time.LocalDate.now());
        colorRepository.saveAndFlush(color);
    }

    @Override
    public void delete(Integer id) {
        colorRepository.deleteById(id);
    }
}
