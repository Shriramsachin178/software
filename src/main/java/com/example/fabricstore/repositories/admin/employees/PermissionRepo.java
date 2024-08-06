package com.example.fabricstore.repositories.admin.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.admin.employees.Permission;

import java.util.List;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {
    List<Permission> findByRoleId(Long roleId);
}
