package com.spring.test.service;

import com.spring.test.dto.TestRequestDto;
import com.spring.test.dto.TestResponseDto;
import com.spring.test.entity.TestEntity;
import com.spring.test.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestResponseDto createPost(TestRequestDto requestDto) {
        TestEntity testEntity = new TestEntity(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getPrice(),
                requestDto.getUsername()
        );
        TestEntity savedEntity = testRepository.save(testEntity);
        return new TestResponseDto(savedEntity);
    }

    public List<TestResponseDto> getPosts() {
        return testRepository.findAll().stream()
                .map(TestResponseDto::new)
                .collect(Collectors.toList());
    }

    public TestResponseDto updatePost(Long id, TestRequestDto requestDto) {
        TestEntity testEntity = testRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id=" + id));
        testEntity.setTitle(requestDto.getTitle());
        testEntity.setContent(requestDto.getContent());
        testEntity.setPrice(requestDto.getPrice());
        testEntity.setUsername(requestDto.getUsername());
        TestEntity updatedEntity = testRepository.save(testEntity);
        return new TestResponseDto(updatedEntity);
    }

    public Long deletePost(Long id) {
        testRepository.deleteById(id);
        return id;
    }
}
