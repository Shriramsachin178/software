package com.example.fabricstore.services.user.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.sales.SalesDetail;
import com.example.fabricstore.models.common.sales.SalesDetailId;
import com.example.fabricstore.repositories.common.sales.SalesDetailRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserSalesDetailService {

    @Autowired
    private SalesDetailRepo salesDetailRepo;

    public List<SalesDetail> getAllSalesDetails() {
        return salesDetailRepo.findAll();
    }

    public Optional<SalesDetail> getSalesDetailById(SalesDetailId id) {
        return salesDetailRepo.findById(id);
    }
}
