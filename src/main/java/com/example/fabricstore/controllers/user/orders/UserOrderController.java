package com.example.fabricstore.controllers.user.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.orders.Order;
import com.example.fabricstore.services.user.orders.UserOrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/orders")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return userOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = userOrderService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
