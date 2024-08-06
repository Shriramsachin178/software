package com.example.fabricstore.services.admin.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.admin.suppliers.SupplierOrderDetail;
import com.example.fabricstore.models.admin.suppliers.SupplierOrderDetailId;
import com.example.fabricstore.repositories.admin.suppliers.SupplierOrderDetailRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierOrderDetailService {

    @Autowired
    private SupplierOrderDetailRepo supplierOrderDetailRepo;

    public List<SupplierOrderDetail> getAllSupplierOrderDetails() {
        return supplierOrderDetailRepo.findAll();
    }

    public Optional<SupplierOrderDetail> getSupplierOrderDetailById(SupplierOrderDetailId id) {
        return supplierOrderDetailRepo.findById(id);
    }

    public SupplierOrderDetail createOrUpdateSupplierOrderDetail(SupplierOrderDetail supplierOrderDetail) {
        return supplierOrderDetailRepo.save(supplierOrderDetail);
    }

    public void deleteSupplierOrderDetail(SupplierOrderDetailId id) {
        supplierOrderDetailRepo.deleteById(id);
    }
}
