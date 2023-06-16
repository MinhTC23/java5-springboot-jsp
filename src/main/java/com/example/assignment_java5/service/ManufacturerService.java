package com.example.assignment_java5.service;

import com.example.assignment_java5.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> getAll();

    Manufacturer detail(Integer id);

    void add(Manufacturer manufacturer);

    void update(Manufacturer manufacturer);

    void delete(Integer id);
}
