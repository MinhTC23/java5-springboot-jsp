package com.example.assignment_java5.repository;

import com.example.assignment_java5.entity.BillProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillProductRepository extends JpaRepository<BillProduct, Integer> {

    @Query(value = "SELECT bp.* FROM bill_product bp JOIN bill b ON bp.ID_Bill = b.Id WHERE b.phone_number = ?1", nativeQuery = true)
    List<BillProduct> search(String phoneNumber);
}
