package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.Manufacturer;
import com.example.assignment_java5.repository.ManufacturerRepository;
import com.example.assignment_java5.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer detail(Integer id) {
        return manufacturerRepository.getById(id);
    }

    @Override
    public void add(Manufacturer manufacturer) {
        manufacturer.setDateCreate(java.time.LocalDate.now());
        manufacturer.setStatus(1);
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void update(Manufacturer manufacturer) {
        manufacturer.setDateCorrect(java.time.LocalDate.now());
        manufacturerRepository.saveAndFlush(manufacturer);
    }

    @Override
    public void delete(Integer id) {
        manufacturerRepository.deleteById(id);
    }
}
