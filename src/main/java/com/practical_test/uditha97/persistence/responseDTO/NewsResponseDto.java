package com.practical_test.uditha97.persistence.responseDTO;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class NewsResponseDto {
    private Long newsId;
    private String newsBody;
    private String newsHeadLine;
    private CategorySimpleDto category;

}
