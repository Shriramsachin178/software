package com.example.fabricstore.services.admin.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.admin.suppliers.Supplier;
import com.example.fabricstore.repositories.admin.suppliers.SupplierRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepo.findById(id);
    }

    public Supplier createOrUpdateSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepo.deleteById(id);
    }
}
