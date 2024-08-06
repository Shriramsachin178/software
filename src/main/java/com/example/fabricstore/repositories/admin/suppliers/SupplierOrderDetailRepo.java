package com.example.fabricstore.repositories.admin.suppliers;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.admin.suppliers.SupplierOrderDetail;
import com.example.fabricstore.models.admin.suppliers.SupplierOrderDetailId;


@Repository
public interface SupplierOrderDetailRepo extends JpaRepository<SupplierOrderDetail, SupplierOrderDetailId> {
}
