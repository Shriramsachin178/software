package com.example.fabricstore.controllers.admin.suppliers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fabricstore.models.admin.suppliers.SupplierOrderDetail;
import com.example.fabricstore.models.admin.suppliers.SupplierOrderDetailId;
import com.example.fabricstore.services.admin.suppliers.SupplierOrderDetailService;

@RestController
@RequestMapping("/supplier-order-details")
public class SupplierOrderDetailController {

    @Autowired
    private SupplierOrderDetailService supplierOrderDetailService;

    @GetMapping
    public List<SupplierOrderDetail> getAllSupplierOrderDetails() {
        return supplierOrderDetailService.getAllSupplierOrderDetails();
    }

    @GetMapping("/{supplierOrderId}/{fabricId}")
    public ResponseEntity<SupplierOrderDetail> getSupplierOrderDetailById(@PathVariable Long supplierOrderId, @PathVariable Long fabricId) {
        SupplierOrderDetailId id = new SupplierOrderDetailId(supplierOrderId, fabricId);
        Optional<SupplierOrderDetail> supplierOrderDetail = supplierOrderDetailService.getSupplierOrderDetailById(id);
        return supplierOrderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SupplierOrderDetail> createOrUpdateSupplierOrderDetail(@RequestBody SupplierOrderDetail supplierOrderDetail) {
        return ResponseEntity.ok(supplierOrderDetailService.createOrUpdateSupplierOrderDetail(supplierOrderDetail));
    }

    @DeleteMapping("/{supplierOrderId}/{fabricId}")
    public ResponseEntity<Void> deleteSupplierOrderDetail(@PathVariable Long supplierOrderId, @PathVariable Long fabricId) {
        SupplierOrderDetailId id = new SupplierOrderDetailId(supplierOrderId, fabricId);
        supplierOrderDetailService.deleteSupplierOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}
