package com.example.fabricstore.controllers.admin.customers;

import java.util.List;
import java.util.Optional;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fabricstore.models.common.customers.CustomerInteraction;
import com.example.fabricstore.services.admin.customers.AdminCustomerInteractionService;


@RestController
@RequestMapping("/admin/customer-interactions")
public class AdminCustomerInteractionController {

    @Autowired
    private AdminCustomerInteractionService adminCustomerInteractionService;

    @GetMapping
    public List<CustomerInteraction> getAllInteractions() {
        return adminCustomerInteractionService.getAllInteractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInteraction> getInteractionById(@PathVariable Long id) {
        Optional<CustomerInteraction> interaction = adminCustomerInteractionService.getInteractionById(id);
        return interaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerInteraction> addOrUpdateInteraction(@RequestBody CustomerInteraction interaction) {
        return ResponseEntity.ok(adminCustomerInteractionService.addOrUpdateInteraction(interaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerInteraction> updateInteraction(@PathVariable Long id, @RequestBody CustomerInteraction updatedInteraction) {
        try {
            CustomerInteraction interaction = adminCustomerInteractionService.updateInteraction(id, updatedInteraction);
            return ResponseEntity.ok(interaction);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {
        adminCustomerInteractionService.deleteInteraction(id);
        return ResponseEntity.noContent().build();
    }
}
