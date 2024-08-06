package com.example.fabricstore.services.user.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.orders.OrderDetail;
import com.example.fabricstore.models.common.orders.OrderDetailId;
import com.example.fabricstore.repositories.common.orders.OrderDetailRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserOrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepo.findAll();
    }

    public Optional<OrderDetail> getOrderDetailById(OrderDetailId id) {
        return orderDetailRepo.findById(id);
    }
}
