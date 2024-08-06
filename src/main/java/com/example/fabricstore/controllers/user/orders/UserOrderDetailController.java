package com.example.fabricstore.controllers.user.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.orders.OrderDetail;
import com.example.fabricstore.models.common.orders.OrderDetailId;
import com.example.fabricstore.services.user.orders.UserOrderDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/order-details")
public class UserOrderDetailController {

    @Autowired
    private UserOrderDetailService userOrderDetailService;

    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return userOrderDetailService.getAllOrderDetails();
    }

    @GetMapping("/{orderId}/{fabricId}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long orderId, @PathVariable Long fabricId) {
        OrderDetailId id = new OrderDetailId(orderId, fabricId);
        Optional<OrderDetail> orderDetail = userOrderDetailService.getOrderDetailById(id);
        return orderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
