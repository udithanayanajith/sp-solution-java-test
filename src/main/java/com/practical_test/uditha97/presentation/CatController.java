package com.practical_test.uditha97.presentation;

import com.practical_test.uditha97.business.CatService;
import com.practical_test.uditha97.models.Category;
import com.practical_test.uditha97.persistence.responseDTO.CategorySimpleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/cat")
@Tag(name = "Category crud", description = "Add and view categories")
public class CatController {
    private final CatService catService;

    public CatController(CatService newsService) {
        this.catService = newsService;
    }

    @PostMapping
    @Operation(summary = "Save a category", description = "Returns saved cat with Id")
    public ResponseEntity<CategorySimpleDto> saveCat(@Valid @RequestBody CategorySimpleDto requestData) {
        return ResponseEntity.ok(catService.saveCat(requestData));
    }

    @GetMapping
    @Operation(summary = "View all categories", description = "Returns saved category data")
    public ResponseEntity<List<CategorySimpleDto>> getCat() {
        return ResponseEntity.ok(catService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "View a category by id", description = "Returns saved and selected cat with Id")
    public ResponseEntity<Optional<CategorySimpleDto>> findCatById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(catService.findCatById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update category description", description = "Returns HTTP status indicating success or failure")
    public ResponseEntity<Void> changeCatDes(@Valid @PathVariable Long id, @RequestBody String newDescription) {
        boolean isUpdated = catService.changeDescription(id, newDescription);
        if (isUpdated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
