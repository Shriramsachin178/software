package com.example.fabricstore.controllers.admin.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.inventory.Fabric;
import com.example.fabricstore.services.admin.inventory.AdminFabricService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/fabrics")
public class AdminFabricController {

    @Autowired
    private AdminFabricService adminFabricService;

    @GetMapping
    public List<Fabric> getAllFabrics() {
        return adminFabricService.getAllFabrics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabric> getFabricById(@PathVariable Long id) {
        Optional<Fabric> fabric = adminFabricService.getFabricById(id);
        return fabric.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fabric> addFabric(@RequestBody Fabric fabric) {
        return ResponseEntity.ok(adminFabricService.addFabric(fabric));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabric> updateFabric(@PathVariable Long id, @RequestBody Fabric fabric) {
        return ResponseEntity.ok(adminFabricService.updateFabric(id, fabric));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabric(@PathVariable Long id) {
        adminFabricService.deleteFabric(id);
        return ResponseEntity.noContent().build();
    }
}
