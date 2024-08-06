package com.example.fabricstore.controllers.user.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fabricstore.models.common.inventory.Category;
import com.example.fabricstore.services.user.inventory.UserCategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/categories")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return userCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = userCategoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
