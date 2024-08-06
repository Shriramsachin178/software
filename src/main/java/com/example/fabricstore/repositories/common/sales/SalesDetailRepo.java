package com.example.fabricstore.repositories.common.sales;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.common.sales.SalesDetail;
import com.example.fabricstore.models.common.sales.SalesDetailId;

import java.util.Optional;

@Repository
public interface SalesDetailRepo extends JpaRepository<SalesDetail, SalesDetailId> {
    Optional<SalesDetail> findBySaleIdAndFabricId(Long saleId, Long fabricId);
}
