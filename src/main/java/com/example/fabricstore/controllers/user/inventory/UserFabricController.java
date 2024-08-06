package com.example.fabricstore.controllers.user.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.inventory.Fabric;
import com.example.fabricstore.services.user.inventory.UserFabricService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/fabrics")
public class UserFabricController {

    @Autowired
    private UserFabricService userFabricService;

    @GetMapping
    public List<Fabric> getAllFabrics() {
        return userFabricService.getAllFabrics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabric> getFabricById(@PathVariable Long id) {
        Optional<Fabric> fabric = userFabricService.getFabricById(id);
        return fabric.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
