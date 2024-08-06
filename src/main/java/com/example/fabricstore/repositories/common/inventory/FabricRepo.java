package com.example.fabricstore.repositories.common.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.common.inventory.Fabric;

@Repository
public interface FabricRepo extends JpaRepository<Fabric, Long> {
}
