package com.example.fabricstore.controllers.user.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.sales.SalesDetail;
import com.example.fabricstore.models.common.sales.SalesDetailId;
import com.example.fabricstore.services.user.sales.UserSalesDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/sales-details")
public class UserSalesDetailController {

    @Autowired
    private UserSalesDetailService userSalesDetailService;

    @GetMapping
    public List<SalesDetail> getAllSalesDetails() {
        return userSalesDetailService.getAllSalesDetails();
    }

    @GetMapping("/{saleId}/{fabricId}")
    public ResponseEntity<SalesDetail> getSalesDetailById(@PathVariable Long saleId, @PathVariable Long fabricId) {
        SalesDetailId id = new SalesDetailId(saleId, fabricId);
        Optional<SalesDetail> salesDetail = userSalesDetailService.getSalesDetailById(id);
        return salesDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
