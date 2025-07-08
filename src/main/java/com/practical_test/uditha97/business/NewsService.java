package com.practical_test.uditha97.business;

import com.practical_test.uditha97.models.Category;
import com.practical_test.uditha97.models.News;
import com.practical_test.uditha97.persistence.requestDTO.NewsRequestDto;
import com.practical_test.uditha97.persistence.responseDTO.CategorySimpleDto;
import com.practical_test.uditha97.persistence.responseDTO.NewsResponseDto;
import com.practical_test.uditha97.repository.CategoryRepositoryTemplate;
import com.practical_test.uditha97.repository.NewsRepositoryTemplate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NewsService {
    private final NewsRepositoryTemplate newsRepositoryTemplate;
    private final CategoryRepositoryTemplate categoryRepositoryTemplate;

    public NewsService(NewsRepositoryTemplate newsRepositoryTemplate,
                       CategoryRepositoryTemplate categoryRepositoryTemplate) {
        this.newsRepositoryTemplate = newsRepositoryTemplate;
        this.categoryRepositoryTemplate = categoryRepositoryTemplate;
    }

    public NewsResponseDto saveNews(NewsRequestDto requestDto) {
        Category category = categoryRepositoryTemplate.findByID(requestDto.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found"));
        if (requestDto.getNewsBody() == null || requestDto.getNewsBody().trim().isEmpty()) {
            throw new IllegalArgumentException("News body is required");
        }

        News news = new News();
        news.setNewsBody(requestDto.getNewsBody().trim());
        news.setNewsHeadLine(requestDto.getNewsHeadLine());
        news.setCategory(category);

        News savedNews = newsRepositoryTemplate.save(news);
        log.info("Saved the data",savedNews);

        return convertToDto(savedNews);
    }

    public List<NewsResponseDto> getAll() {
        return newsRepositoryTemplate.findAllNewss().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public NewsResponseDto findNewsById(Long id) {
        return newsRepositoryTemplate.findNewsByID(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "News not found with id: " + id));
    }

    private NewsResponseDto convertToDto(News news) {
        NewsResponseDto dto = new NewsResponseDto();
        dto.setNewsId(news.getId());
        dto.setNewsBody(news.getNewsBody());
        dto.setNewsHeadLine(news.getNewsHeadLine());

        if (news.getCategory() != null) {
            CategorySimpleDto categorySimpleDto = new CategorySimpleDto();
            categorySimpleDto.setCatId(news.getCategory().getId());
            categorySimpleDto.setCatDescription(news.getCategory().getDescription());
            dto.setCategory(categorySimpleDto);
        }

        return dto;
    }


    public List<NewsResponseDto> findNewsByCatID(@Valid Long id) {
        List<News> newsList = newsRepositoryTemplate.findNewsByCatID(id);
        return newsList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
