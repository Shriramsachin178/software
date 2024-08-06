package com.example.fabricstore.controllers.admin.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.inventory.Category;
import com.example.fabricstore.services.admin.inventory.AdminCategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService adminCategoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return adminCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = adminCategoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> addOrUpdateCategory(@RequestBody Category category) {
        return ResponseEntity.ok(adminCategoryService.addOrUpdateCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        adminCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
