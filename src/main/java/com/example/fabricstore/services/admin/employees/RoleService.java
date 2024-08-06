package com.example.fabricstore.services.admin.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.admin.employees.Role;
import com.example.fabricstore.repositories.admin.employees.RoleRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepo.findById(id);
    }

    public Role createOrUpdateRole(Role role) {
        return roleRepo.save(role);
    }

    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }
}
