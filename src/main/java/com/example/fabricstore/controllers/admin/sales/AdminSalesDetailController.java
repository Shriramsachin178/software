package com.example.fabricstore.controllers.admin.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.sales.SalesDetail;
import com.example.fabricstore.models.common.sales.SalesDetailId;
import com.example.fabricstore.services.admin.sales.AdminSalesDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/sales-details")
public class AdminSalesDetailController {

    @Autowired
    private AdminSalesDetailService adminSalesDetailService;

    @GetMapping
    public List<SalesDetail> getAllSalesDetails() {
        return adminSalesDetailService.getAllSalesDetails();
    }

    @GetMapping("/{saleId}/{fabricId}")
    public ResponseEntity<SalesDetail> getSalesDetailById(@PathVariable Long saleId, @PathVariable Long fabricId) {
        SalesDetailId id = new SalesDetailId(saleId, fabricId);
        Optional<SalesDetail> salesDetail = adminSalesDetailService.getSalesDetailById(id);
        return salesDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalesDetail> createOrUpdateSalesDetail(@RequestBody SalesDetail salesDetail) {
        return ResponseEntity.ok(adminSalesDetailService.createOrUpdateSalesDetail(salesDetail));
    }

    @DeleteMapping("/{saleId}/{fabricId}")
    public ResponseEntity<Void> deleteSalesDetail(@PathVariable Long saleId, @PathVariable Long fabricId) {
        SalesDetailId id = new SalesDetailId(saleId, fabricId);
        adminSalesDetailService.deleteSalesDetail(id);
        return ResponseEntity.noContent().build();
    }
}
