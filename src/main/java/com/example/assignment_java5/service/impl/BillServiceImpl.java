package com.example.assignment_java5.service.impl;

import com.example.assignment_java5.entity.Bill;
import com.example.assignment_java5.repository.BillRepository;
import com.example.assignment_java5.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public void add(Bill bill) {
        Random random = new Random();
        int number = random.nextInt(100) + 1; // Số nguyên ngẫu nhiên
        String codeBill = "Bill" + number;
        bill.setCode(codeBill);
        bill.setPurchaseDate(java.time.LocalDate.now());
        bill.setStatus(1);
        bill.setCustomer(null);
        billRepository.save(bill);
    }

}
