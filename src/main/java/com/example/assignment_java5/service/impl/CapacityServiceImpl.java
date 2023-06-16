package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.Capacity;
import com.example.assignment_java5.repository.CapacityRepository;
import com.example.assignment_java5.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapacityServiceImpl implements CapacityService {

    @Autowired
    private CapacityRepository capacityRepository;

    @Override
    public List<Capacity> getAll() {
        return capacityRepository.findAll();
    }

    @Override
    public Capacity detail(Integer id) {
        return capacityRepository.getById(id);
    }

    @Override
    public void add(Capacity capacity) {
        capacity.setDateCreate(java.time.LocalDate.now());
        capacity.setStatus(1);
        capacityRepository.save(capacity);
    }

    @Override
    public void update(Capacity capacity) {
        capacity.setDateCorrect(java.time.LocalDate.now());
        capacityRepository.saveAndFlush(capacity);
    }

    @Override
    public void delete(Integer id) {
        capacityRepository.deleteById(id);
    }
}
