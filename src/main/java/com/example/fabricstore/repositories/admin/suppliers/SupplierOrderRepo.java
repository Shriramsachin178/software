package com.example.fabricstore.repositories.admin.suppliers;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.admin.suppliers.SupplierOrder;


@Repository
public interface SupplierOrderRepo extends JpaRepository<SupplierOrder, Long> {
}
