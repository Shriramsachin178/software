package com.example.fabricstore.services.admin.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.admin.employees.Permission;
import com.example.fabricstore.repositories.admin.employees.PermissionRepo;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepo permissionRepo;

    public List<Permission> getAllPermissions() {
        return permissionRepo.findAll();
    }

    public List<Permission> getPermissionsByRoleId(Long roleId) {
        return permissionRepo.findByRoleId(roleId);
    }

    public Permission createOrUpdatePermission(Permission permission) {
        return permissionRepo.save(permission);
    }

    public void deletePermission(Long id) {
        permissionRepo.deleteById(id);
    }
}
