package com.example.fabricstore.services.user.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.inventory.StockAdjustment;
import com.example.fabricstore.repositories.common.inventory.StockAdjustmentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserStockAdjustmentService {

    @Autowired
    private StockAdjustmentRepo stockAdjustmentRepo;

    public List<StockAdjustment> getAllAdjustments() {
        return stockAdjustmentRepo.findAll();
    }

    public Optional<StockAdjustment> getAdjustmentById(Long id) {
        return stockAdjustmentRepo.findById(id);
    }
}
