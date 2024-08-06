package com.example.fabricstore.repositories.common.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fabricstore.models.common.customers.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    
}
