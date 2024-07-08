package com.spring.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}
