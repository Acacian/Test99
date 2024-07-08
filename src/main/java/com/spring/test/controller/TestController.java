package com.spring.test.controller;

import com.spring.test.dto.TestRequestDto;
import com.spring.test.dto.TestResponseDto;
import com.spring.test.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/posts")
    public TestResponseDto createPost(@RequestBody TestRequestDto requestDto) {
        return testService.createPost(requestDto);
    }

    @GetMapping("/posts")
    public List<TestResponseDto> getPosts() {
        return testService.getPosts();
    }

    @PutMapping("/posts/{id}")
    public TestResponseDto updatePost(@PathVariable Long id, @RequestBody TestRequestDto requestDto) {
        return testService.updatePost(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        return testService.deletePost(id);
    }
}
