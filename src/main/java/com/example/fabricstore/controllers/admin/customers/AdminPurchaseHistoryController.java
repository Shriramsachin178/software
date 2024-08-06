package com.example.fabricstore.controllers.admin.customers;

import com.example.fabricstore.models.common.customers.PurchaseHistory;
import com.example.fabricstore.services.admin.customers.AdminPurchaseHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/purchase-history")
public class AdminPurchaseHistoryController {

    @Autowired
    private AdminPurchaseHistoryService adminPurchaseHistoryService;

    @GetMapping
    public List<PurchaseHistory> getAllPurchases() {
        return adminPurchaseHistoryService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseHistory> getPurchaseById(@PathVariable Long id) {
        Optional<PurchaseHistory> purchase = adminPurchaseHistoryService.getPurchaseById(id);
        return purchase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PurchaseHistory> addOrUpdatePurchase(@RequestBody PurchaseHistory purchase) {
        return ResponseEntity.ok(adminPurchaseHistoryService.addOrUpdatePurchase(purchase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        adminPurchaseHistoryService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }
}
