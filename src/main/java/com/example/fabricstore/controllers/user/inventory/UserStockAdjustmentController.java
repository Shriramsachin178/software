package com.example.fabricstore.controllers.user.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.inventory.StockAdjustment;
import com.example.fabricstore.services.user.inventory.UserStockAdjustmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/stock-adjustments")
public class UserStockAdjustmentController {

    @Autowired
    private UserStockAdjustmentService userStockAdjustmentService;

    @GetMapping
    public List<StockAdjustment> getAllAdjustments() {
        return userStockAdjustmentService.getAllAdjustments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockAdjustment> getAdjustmentById(@PathVariable Long id) {
        Optional<StockAdjustment> adjustment = userStockAdjustmentService.getAdjustmentById(id);
        return adjustment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
