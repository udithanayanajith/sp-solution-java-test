package com.practical_test.uditha97.presentation;

import com.practical_test.uditha97.business.NewsService;
import com.practical_test.uditha97.persistence.requestDTO.NewsRequestDto;
import com.practical_test.uditha97.persistence.responseDTO.NewsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    @Operation(summary = "Save a news")
    public ResponseEntity<NewsResponseDto> saveNews(@Valid @RequestBody NewsRequestDto requestData){
        return ResponseEntity.ok(newsService.saveNews(requestData));
    }

    @GetMapping
    public ResponseEntity<List<NewsResponseDto>> getNews(){
        return ResponseEntity.ok(newsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponseDto> findNewsByID(@Valid @PathVariable Long id){
        return ResponseEntity.ok(newsService.findNewsById(id));
    }
    @GetMapping("/allNewsByCatId/{id}")
    public ResponseEntity<List<NewsResponseDto>> findNewsByCatID(@Valid @PathVariable Long id){
        return ResponseEntity.ok(newsService.findNewsByCatID(id));
    }
}
