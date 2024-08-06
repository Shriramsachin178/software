package com.example.fabricstore.controllers.user.customers;

import com.example.fabricstore.models.common.customers.CustomerInteraction;
import com.example.fabricstore.services.user.customers.UserCustomerInteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/customer-interactions")
public class UserCustomerInteractionController {

    @Autowired
    private UserCustomerInteractionService userCustomerInteractionService;

    @GetMapping
    public List<CustomerInteraction> getAllInteractions() {
        return userCustomerInteractionService.getAllInteractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInteraction> getInteractionById(@PathVariable Long id) {
        Optional<CustomerInteraction> interaction = userCustomerInteractionService.getInteractionById(id);
        return interaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
