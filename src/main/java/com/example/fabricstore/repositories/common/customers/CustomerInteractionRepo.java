package com.example.fabricstore.repositories.common.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fabricstore.models.common.customers.CustomerInteraction;

@Repository
public interface CustomerInteractionRepo extends JpaRepository<CustomerInteraction, Long> {
    // Additional query methods can be defined here if needed
}
