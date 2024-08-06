package com.example.fabricstore.services.admin.customers;

import java.util.List;
import java.util.Optional;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.customers.CustomerInteraction;
import com.example.fabricstore.repositories.common.customers.CustomerInteractionRepo;

@Service
public class AdminCustomerInteractionService {

    @Autowired
    private CustomerInteractionRepo customerInteractionRepo;

    public List<CustomerInteraction> getAllInteractions() {
        return customerInteractionRepo.findAll();
    }

    public Optional<CustomerInteraction> getInteractionById(Long id) {
        return customerInteractionRepo.findById(id);
    }

    public CustomerInteraction addOrUpdateInteraction(CustomerInteraction interaction) {
        return customerInteractionRepo.save(interaction);
    }

    public CustomerInteraction updateInteraction(Long id, CustomerInteraction updatedInteraction) {
        if (customerInteractionRepo.existsById(id)) {
            updatedInteraction.setId(id);
            return customerInteractionRepo.save(updatedInteraction);
        } else {
            throw new ResourceNotFoundException("CustomerInteraction with id " + id + " not found");
        }
    }

    public void deleteInteraction(Long id) {
        customerInteractionRepo.deleteById(id);
    }
}
