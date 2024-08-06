package com.example.fabricstore.repositories.admin.suppliers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.admin.suppliers.Supplier;



@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long> {
}
