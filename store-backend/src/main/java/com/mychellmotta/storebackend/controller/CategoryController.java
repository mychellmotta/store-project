package com.mychellmotta.storebackend.controller;

import com.mychellmotta.storebackend.entity.Category;
import com.mychellmotta.storebackend.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("/")
    public Category insert(@RequestBody Category category) {
        return categoryService.insert(category);
    }

    @PutMapping("/")
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
