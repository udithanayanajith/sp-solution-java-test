package com.practical_test.uditha97.repository.IMPL;

import com.practical_test.uditha97.models.News;
import com.practical_test.uditha97.repository.NewsRepository;
import com.practical_test.uditha97.repository.NewsRepositoryTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsRepoIMPL implements NewsRepositoryTemplate {
    private final NewsRepository newsRepository;

    public NewsRepoIMPL(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News save(News requestDto) {
        return  newsRepository.save(requestDto);
    }

    @Override
    public List<News> findAllNewss() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> findNewsByID(Long Id) {
        return newsRepository.findById(Id);
    }

    @Override
    public List<News> findNewsByCatID(Long id) {
        return newsRepository.findAllByCategoryId(id);
    }

}
