package com.bda.parcial.services;

import com.bda.parcial.models.Category;
import com.bda.parcial.models.Customer;
import com.bda.parcial.repositories.CategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category add(Category entity) {
        return this.categoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        return this.categoryRepository.save(entity);
    }

    @Override
    public Category delete(Long id) {
        Category category = this.getById(id);
        this.categoryRepository.delete(category);
        return category;
    }

    @Override
    public Category getById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
