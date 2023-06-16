package com.example.assignment_java5.repository;

import com.example.assignment_java5.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Integer> {
}
