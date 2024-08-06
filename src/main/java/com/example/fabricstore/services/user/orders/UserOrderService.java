package com.example.fabricstore.services.user.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.orders.Order;
import com.example.fabricstore.repositories.common.orders.OrderRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserOrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }
}
