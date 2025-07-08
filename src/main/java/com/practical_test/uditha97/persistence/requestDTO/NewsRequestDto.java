package com.practical_test.uditha97.persistence.requestDTO;

import lombok.Data;

@Data
public class NewsRequestDto {
    private String newsBody;
    private String newsHeadLine;
    private Long categoryId;
}
