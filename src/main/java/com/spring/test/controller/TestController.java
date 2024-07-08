package com.spring.test.controller;

import com.spring.test.dto.TestRequestDto;
import com.spring.test.dto.TestResponseDto;
import com.spring.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/post")
    public TestResponseDto createPost(@RequestBody TestRequestDto requestDto) {
        logger.debug("Received POST request for /post with data: {}", requestDto);
        return testService.createPost(requestDto);
    }

    @GetMapping("/post")
    public List<TestResponseDto> getPosts() {
        logger.debug("Received GET request for /post");
        return testService.getPosts();
    }

    @PutMapping("/post/{id}")
    public TestResponseDto updatePost(@PathVariable Long id, @RequestBody TestRequestDto requestDto) {
        logger.debug("Received PUT request for /post/{} with data: {}", id, requestDto);
        return testService.updatePost(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Map<String, String> deletePost(@PathVariable Long id) {
        logger.debug("Received DELETE request for /post/{}", id);
        testService.deletePost(id);
        return Map.of("msg", "삭제완료");
    }
}

@RestController
class HealthController {

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
