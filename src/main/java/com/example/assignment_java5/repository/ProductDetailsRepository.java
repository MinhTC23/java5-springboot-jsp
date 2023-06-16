package com.example.assignment_java5.repository;

import com.example.assignment_java5.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

    @Query(value = "update Product_Details set number = number - ?1 where id = ?2", nativeQuery = true)
    void updateNumber(Integer number, Integer id);
}
