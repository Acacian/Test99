package com.spring.test.controller;

import com.spring.test.dto.TestRequestDto;
import com.spring.test.dto.TestResponseDto;
import com.spring.test.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/post")
    public TestResponseDto createPost(@RequestBody TestRequestDto requestDto) {
        return testService.createPost(requestDto);
    }

    @GetMapping("/post")
    public List<TestResponseDto> getPosts() {
        return testService.getPosts();
    }

    @PutMapping("/post/{id}")
    public TestResponseDto updatePost(@PathVariable Long id, @RequestBody TestRequestDto requestDto) {
        return testService.updatePost(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Map<String, String> deletePost(@PathVariable Long id) {
        testService.deletePost(id);
        return Map.of("msg", "삭제완료");
    }
}
