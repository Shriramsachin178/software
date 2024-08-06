package com.example.fabricstore.services.admin.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.admin.suppliers.SupplierOrder;
import com.example.fabricstore.repositories.admin.suppliers.SupplierOrderRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierOrderService {

    @Autowired
    private SupplierOrderRepo supplierOrderRepo;

    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderRepo.findAll();
    }

    public Optional<SupplierOrder> getSupplierOrderById(Long id) {
        return supplierOrderRepo.findById(id);
    }

    public SupplierOrder createOrUpdateSupplierOrder(SupplierOrder supplierOrder) {
        return supplierOrderRepo.save(supplierOrder);
    }

    public void deleteSupplierOrder(Long id) {
        supplierOrderRepo.deleteById(id);
    }
}
