package com.example.fabricstore.services.user.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.inventory.Fabric;
import com.example.fabricstore.repositories.common.inventory.FabricRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserFabricService {

    @Autowired
    private FabricRepo fabricRepo;

    public List<Fabric> getAllFabrics() {
        return fabricRepo.findAll();
    }

    public Optional<Fabric> getFabricById(Long id) {
        return fabricRepo.findById(id);
    }
}
