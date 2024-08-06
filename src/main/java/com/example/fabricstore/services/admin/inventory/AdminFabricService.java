package com.example.fabricstore.services.admin.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.inventory.Fabric;
import com.example.fabricstore.repositories.common.inventory.FabricRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AdminFabricService {

    @Autowired
    private FabricRepo fabricRepo;

    public List<Fabric> getAllFabrics() {
        return fabricRepo.findAll();
    }

    public Optional<Fabric> getFabricById(Long id) {
        return fabricRepo.findById(id);
    }

    public Fabric addFabric(Fabric fabric) {
        return fabricRepo.save(fabric);
    }

    public Fabric updateFabric(Long id, Fabric updatedFabric) {
        Optional<Fabric> existingFabricOpt = fabricRepo.findById(id);
        if (existingFabricOpt.isPresent()) {
            Fabric existingFabric = existingFabricOpt.get();
            existingFabric.setName(updatedFabric.getName());
            existingFabric.setDescription(updatedFabric.getDescription());
            existingFabric.setCategory(updatedFabric.getCategory());
            existingFabric.setQuantity(updatedFabric.getQuantity());
            existingFabric.setUnitPrice(updatedFabric.getUnitPrice());
            existingFabric.setReorderLevel(updatedFabric.getReorderLevel());
            return fabricRepo.save(existingFabric);
        } else {
            throw new IllegalArgumentException("Fabric with ID " + id + " not found.");
        }
    }

    public void deleteFabric(Long id) {
        fabricRepo.deleteById(id);
    }
}
