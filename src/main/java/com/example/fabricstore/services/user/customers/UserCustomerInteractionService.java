package com.example.fabricstore.services.user.customers;

import com.example.fabricstore.models.common.customers.CustomerInteraction;
import com.example.fabricstore.repositories.common.customers.CustomerInteractionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCustomerInteractionService {

    @Autowired
    private CustomerInteractionRepo customerInteractionRepo;

    public List<CustomerInteraction> getAllInteractions() {
        return customerInteractionRepo.findAll();
    }

    public Optional<CustomerInteraction> getInteractionById(Long id) {
        return customerInteractionRepo.findById(id);
    }
}
