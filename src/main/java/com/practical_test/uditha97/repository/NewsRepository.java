package com.practical_test.uditha97.repository;

import com.practical_test.uditha97.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
    @Query("SELECT n FROM News n WHERE n.category.id = :categoryId")
    List<News> findAllByCategoryId(@Param("categoryId") Long categoryId);

}
