package com.practical_test.uditha97.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "news",
        indexes = @Index(name = "idx_news_name", columnList = "newsHeadLine"))
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "news_body",nullable =false )
    private String newsBody;

    @Column(name = "news_headline", nullable = false, precision = 10, scale = 2)
    private String newsHeadLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_news_category"))
    private Category category;
}