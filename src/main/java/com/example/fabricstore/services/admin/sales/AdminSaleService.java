package com.example.fabricstore.services.admin.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.sales.Sale;
import com.example.fabricstore.repositories.common.sales.SaleRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AdminSaleService {

    @Autowired
    private SaleRepo saleRepo;

    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepo.findById(id);
    }

    public Sale createOrUpdateSale(Sale sale) {
        return saleRepo.save(sale);
    }

    public void deleteSale(Long id) {
        saleRepo.deleteById(id);
    }
}
