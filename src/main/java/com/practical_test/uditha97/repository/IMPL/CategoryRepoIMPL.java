package com.practical_test.uditha97.repository.IMPL;

import com.practical_test.uditha97.models.Category;
import com.practical_test.uditha97.repository.CategoryRepository;
import com.practical_test.uditha97.repository.CategoryRepositoryTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryRepoIMPL implements CategoryRepositoryTemplate {
    private final CategoryRepository categoryRepository;

    public CategoryRepoIMPL(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findByID(Long Id) {
        return categoryRepository.findById(Id);
    }

    @Override
    public Category saveCat(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCat() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findCatById(Long Id) {
        return categoryRepository.findById(Id);
    }
}
