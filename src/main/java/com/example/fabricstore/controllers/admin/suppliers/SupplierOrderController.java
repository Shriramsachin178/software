package com.example.fabricstore.controllers.admin.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.admin.suppliers.SupplierOrder;
import com.example.fabricstore.services.admin.suppliers.SupplierOrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier-orders")
public class SupplierOrderController {

    @Autowired
    private SupplierOrderService supplierOrderService;

    @GetMapping
    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderService.getAllSupplierOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierOrder> getSupplierOrderById(@PathVariable Long id) {
        Optional<SupplierOrder> supplierOrder = supplierOrderService.getSupplierOrderById(id);
        return supplierOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SupplierOrder> createOrUpdateSupplierOrder(@RequestBody SupplierOrder supplierOrder) {
        return ResponseEntity.ok(supplierOrderService.createOrUpdateSupplierOrder(supplierOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierOrder(@PathVariable Long id) {
        supplierOrderService.deleteSupplierOrder(id);
        return ResponseEntity.noContent().build();
    }
}
