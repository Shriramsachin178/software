package com.example.fabricstore.controllers.user.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.sales.Sale;
import com.example.fabricstore.services.user.sales.UserSaleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/sales")
public class UserSaleController {

    @Autowired
    private UserSaleService userSaleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return userSaleService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Optional<Sale> sale = userSaleService.getSaleById(id);
        return sale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
