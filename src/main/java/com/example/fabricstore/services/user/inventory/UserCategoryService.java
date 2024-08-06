package com.example.fabricstore.services.user.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fabricstore.models.common.inventory.Category;
import com.example.fabricstore.repositories.common.inventory.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepo.findById(id);
    }
}
