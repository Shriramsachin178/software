package com.example.fabricstore.controllers.admin.customers;

import com.example.fabricstore.models.common.customers.Customer;
import com.example.fabricstore.services.admin.customers.AdminCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/customers")
public class AdminCustomerController {

    @Autowired
    private AdminCustomerService adminCustomerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return adminCustomerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = adminCustomerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> addOrUpdateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(adminCustomerService.addOrUpdateCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        adminCustomerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
