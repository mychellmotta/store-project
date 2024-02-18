package com.mychellmotta.storebackend.services;

import com.mychellmotta.storebackend.entity.Category;
import com.mychellmotta.storebackend.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category insert(Category category) {
        category.setInsertDate(new Date());
        return categoryRepository.save(category);
    }

    @Transactional
    public Category update(Category category) {
        category.setUpdateDate(new Date());
        return categoryRepository.save(category);
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
