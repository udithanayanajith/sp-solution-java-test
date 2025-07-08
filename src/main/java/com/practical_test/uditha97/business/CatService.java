package com.practical_test.uditha97.business;

import com.practical_test.uditha97.models.Category;
import com.practical_test.uditha97.persistence.responseDTO.CategorySimpleDto;
import com.practical_test.uditha97.repository.CategoryRepositoryTemplate;
import jakarta.validation.Valid;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatService {
    private final CategoryRepositoryTemplate categoryRepositoryTemplate;

    public CatService(CategoryRepositoryTemplate categoryRepositoryTemplate) {
        this.categoryRepositoryTemplate = categoryRepositoryTemplate;
    }

    public CategorySimpleDto saveCat(CategorySimpleDto requestData) {
        Category category = new Category();
        category.setDescription(requestData.getCatDescription());
        return convertToDTO(categoryRepositoryTemplate.saveCat(category));
    }

    public List<CategorySimpleDto> getAll() {
        return categoryRepositoryTemplate.findAllCat().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategorySimpleDto> findCatById(@Valid Long id) {
        try {
            return categoryRepositoryTemplate.findCatById(id)
                    .map(this::convertToDTO);
        } catch (Exception e) {
            throw new ServiceException("Failed to retrieve categories", e);
        }
    }


    public boolean changeDescription(@Valid Long id, String newDescription) {
        Optional<Category> existingCategory=categoryRepositoryTemplate.findCatById(id);
        if (existingCategory.isPresent()){
            Category newCategory = existingCategory.get();
            newCategory.setDescription(newDescription);
            categoryRepositoryTemplate.saveCat(newCategory);
        }
        return false;
    }

    private CategorySimpleDto convertToDTO(Category category) {
        CategorySimpleDto categorySimpleDto = new CategorySimpleDto();
        categorySimpleDto.setCatId(category.getId());
        categorySimpleDto.setCatDescription(category.getDescription());
        return categorySimpleDto;
    }


}
