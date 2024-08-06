package com.example.fabricstore.services.admin.customers;

import com.example.fabricstore.models.common.customers.Customer;
import com.example.fabricstore.repositories.common.customers.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }

    public Customer addOrUpdateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}


