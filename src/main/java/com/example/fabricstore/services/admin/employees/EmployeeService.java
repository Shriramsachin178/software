package com.example.fabricstore.services.admin.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.admin.employees.Employee;
import com.example.fabricstore.repositories.admin.employees.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public Employee createOrUpdateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public Optional<Employee> findByUsername(String username) {
        return employeeRepo.findByUsername(username);
    }

    public Optional<Employee> findByEmail(String email) {
        return employeeRepo.findByEmail(email);
    }
}
