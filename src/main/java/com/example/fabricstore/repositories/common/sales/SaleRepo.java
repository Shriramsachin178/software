package com.example.fabricstore.repositories.common.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.common.sales.Sale;


@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {
}
