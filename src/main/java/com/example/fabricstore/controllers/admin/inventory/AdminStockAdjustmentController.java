package com.example.fabricstore.controllers.admin.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.inventory.StockAdjustment;
import com.example.fabricstore.services.admin.inventory.AdminStockAdjustmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/stock-adjustments")
public class AdminStockAdjustmentController {

    @Autowired
    private AdminStockAdjustmentService adminStockAdjustmentService;

    @GetMapping
    public List<StockAdjustment> getAllAdjustments() {
        return adminStockAdjustmentService.getAllAdjustments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockAdjustment> getAdjustmentById(@PathVariable Long id) {
        Optional<StockAdjustment> adjustment = adminStockAdjustmentService.getAdjustmentById(id);
        return adjustment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StockAdjustment> addOrUpdateAdjustment(@RequestBody StockAdjustment adjustment) {
        return ResponseEntity.ok(adminStockAdjustmentService.addOrUpdateAdjustment(adjustment));
    }
}
