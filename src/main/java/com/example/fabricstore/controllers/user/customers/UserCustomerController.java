package com.example.fabricstore.controllers.user.customers;

import com.example.fabricstore.models.common.customers.Customer;
import com.example.fabricstore.services.user.customers.UserCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/customers")
public class UserCustomerController {

    @Autowired
    private UserCustomerService userCustomerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return userCustomerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = userCustomerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
