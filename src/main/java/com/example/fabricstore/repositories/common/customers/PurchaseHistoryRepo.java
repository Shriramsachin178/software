package com.example.fabricstore.repositories.common.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fabricstore.models.common.customers.PurchaseHistory;

@Repository
public interface PurchaseHistoryRepo extends JpaRepository<PurchaseHistory, Long> {
    
}
