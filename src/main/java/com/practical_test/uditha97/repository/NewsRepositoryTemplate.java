package com.practical_test.uditha97.repository;

import com.practical_test.uditha97.models.News;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface NewsRepositoryTemplate {
    News save(News news);

    List<News> findAllNewss();

    Optional<News> findNewsByID(Long Id);

    List<News> findNewsByCatID(@Valid Long id);
}
