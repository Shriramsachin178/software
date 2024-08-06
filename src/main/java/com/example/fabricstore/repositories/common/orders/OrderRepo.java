package com.example.fabricstore.repositories.common.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.common.orders.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    // Custom queries if needed
}
