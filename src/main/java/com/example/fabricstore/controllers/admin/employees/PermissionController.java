package com.example.fabricstore.controllers.admin.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.admin.employees.Permission;
import com.example.fabricstore.services.admin.employees.PermissionService;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/role/{roleId}")
    public List<Permission> getPermissionsByRoleId(@PathVariable Long roleId) {
        return permissionService.getPermissionsByRoleId(roleId);
    }

    @PostMapping
    public ResponseEntity<Permission> createOrUpdatePermission(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.createOrUpdatePermission(permission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
