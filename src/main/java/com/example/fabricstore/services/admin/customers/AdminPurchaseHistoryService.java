package com.example.fabricstore.services.admin.customers;

import com.example.fabricstore.models.common.customers.PurchaseHistory;
import com.example.fabricstore.repositories.common.customers.PurchaseHistoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminPurchaseHistoryService {

    @Autowired
    private PurchaseHistoryRepo purchaseHistoryRepo;

    public List<PurchaseHistory> getAllPurchases() {
        return purchaseHistoryRepo.findAll();
    }

    public Optional<PurchaseHistory> getPurchaseById(Long id) {
        return purchaseHistoryRepo.findById(id);
    }

    public PurchaseHistory addOrUpdatePurchase(PurchaseHistory purchase) {
        return purchaseHistoryRepo.save(purchase);
    }

    public void deletePurchase(Long id) {
        purchaseHistoryRepo.deleteById(id);
    }
}

