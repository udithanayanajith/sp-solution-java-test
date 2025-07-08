package com.practical_test.uditha97.repository;

import com.practical_test.uditha97.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryTemplate {
    Optional<Category> findByID(Long Id);

    Category saveCat(Category category);

    List<Category> findAllCat();

    Optional<Category> findCatById(Long Id);
}
