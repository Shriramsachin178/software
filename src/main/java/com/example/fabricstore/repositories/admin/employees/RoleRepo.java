package com.example.fabricstore.repositories.admin.employees;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fabricstore.models.admin.employees.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
