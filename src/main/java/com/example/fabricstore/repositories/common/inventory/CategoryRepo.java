package com.example.fabricstore.repositories.common.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.common.inventory.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
