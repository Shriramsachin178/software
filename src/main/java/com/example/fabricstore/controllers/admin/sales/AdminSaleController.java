package com.example.fabricstore.controllers.admin.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.sales.Sale;
import com.example.fabricstore.services.admin.sales.AdminSaleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/sales")
public class AdminSaleController {

    @Autowired
    private AdminSaleService adminSaleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return adminSaleService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Optional<Sale> sale = adminSaleService.getSaleById(id);
        return sale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sale> createOrUpdateSale(@RequestBody Sale sale) {
        return ResponseEntity.ok(adminSaleService.createOrUpdateSale(sale));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        adminSaleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
