package com.example.fabricstore.controllers.admin.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.orders.OrderDetail;
import com.example.fabricstore.models.common.orders.OrderDetailId;
import com.example.fabricstore.services.admin.orders.AdminOrderDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/order-details")
public class AdminOrderDetailController {

    @Autowired
    private AdminOrderDetailService adminOrderDetailService;

    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return adminOrderDetailService.getAllOrderDetails();
    }

    @GetMapping("/{orderId}/{fabricId}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long orderId, @PathVariable Long fabricId) {
        OrderDetailId id = new OrderDetailId(orderId, fabricId);
        Optional<OrderDetail> orderDetail = adminOrderDetailService.getOrderDetailById(id);
        return orderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrUpdateOrderDetail(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok(adminOrderDetailService.createOrUpdateOrderDetail(orderDetail));
    }

    @DeleteMapping("/{orderId}/{fabricId}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long orderId, @PathVariable Long fabricId) {
        OrderDetailId id = new OrderDetailId(orderId, fabricId);
        adminOrderDetailService.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}
