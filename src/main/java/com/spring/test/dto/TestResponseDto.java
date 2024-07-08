package com.spring.test.dto;

import com.spring.test.entity.TestEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public TestResponseDto(TestEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.price = entity.getPrice();
        this.username = entity.getUsername();
    }
}
