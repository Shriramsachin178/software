package com.example.fabricstore.services.user.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.sales.Sale;
import com.example.fabricstore.repositories.common.sales.SaleRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserSaleService {

    @Autowired
    private SaleRepo saleRepo;

    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepo.findById(id);
    }
}
