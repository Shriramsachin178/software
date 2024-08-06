package com.example.fabricstore.controllers.user.customers;

import com.example.fabricstore.models.common.customers.PurchaseHistory;
import com.example.fabricstore.services.user.customers.UserPurchaseHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/purchase-history")
public class UserPurchaseHistoryController {

    @Autowired
    private UserPurchaseHistoryService userPurchaseHistoryService;

    @GetMapping
    public List<PurchaseHistory> getAllPurchases() {
        return userPurchaseHistoryService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseHistory> getPurchaseById(@PathVariable Long id) {
        Optional<PurchaseHistory> purchase = userPurchaseHistoryService.getPurchaseById(id);
        return purchase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
