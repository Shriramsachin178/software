package com.example.fabricstore.services.admin.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.sales.SalesDetail;
import com.example.fabricstore.models.common.sales.SalesDetailId;
import com.example.fabricstore.repositories.common.sales.SalesDetailRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AdminSalesDetailService {

    @Autowired
    private SalesDetailRepo salesDetailRepo;

    public List<SalesDetail> getAllSalesDetails() {
        return salesDetailRepo.findAll();
    }

    public Optional<SalesDetail> getSalesDetailById(SalesDetailId id) {
        return salesDetailRepo.findById(id);
    }

    public SalesDetail createOrUpdateSalesDetail(SalesDetail salesDetail) {
        return salesDetailRepo.save(salesDetail);
    }

    public void deleteSalesDetail(SalesDetailId id) {
        salesDetailRepo.deleteById(id);
    }

    public Optional<SalesDetail> findBySaleIdAndFabricId(Long saleId, Long fabricId) {
        return salesDetailRepo.findBySaleIdAndFabricId(saleId, fabricId);
    }
}
