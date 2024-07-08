package com.spring.test.service;

import com.spring.test.dto.TestDTO;
import com.spring.test.entity.TestEntity;
import com.spring.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public TestDTO createItem(TestDTO testDTO) {
        TestEntity testEntity = new TestEntity();
        testEntity.setTitle(testDTO.getTitle());
        testEntity.setContent(testDTO.getContent());
        testEntity.setPrice(testDTO.getPrice());
        testEntity.setUsername(testDTO.getUsername());
        testEntity = testRepository.save(testEntity);
        testDTO.setId(testEntity.getId());
        return testDTO;
    }

    public List<TestDTO> getAllItems() {
        return testRepository.findAll().stream().map(entity -> {
            TestDTO dto = new TestDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setContent(entity.getContent());
            dto.setPrice(entity.getPrice());
            dto.setUsername(entity.getUsername());
            return dto;
        }).collect(Collectors.toList());
    }

    public TestDTO updateItem(Long id, TestDTO testDTO) {
        TestEntity testEntity = testRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        testEntity.setTitle(testDTO.getTitle());
        testEntity.setContent(testDTO.getContent());
        testEntity.setPrice(testDTO.getPrice());
        testEntity.setUsername(testDTO.getUsername());
        testEntity = testRepository.save(testEntity);
        testDTO.setId(testEntity.getId());
        return testDTO;
    }

    public void deleteItem(Long id) {
        testRepository.deleteById(id);
    }
}
