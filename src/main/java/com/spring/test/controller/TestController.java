package com.spring.test.controller;

import com.spring.test.dto.TestDTO;
import com.spring.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping
    public TestDTO createItem(@RequestBody TestDTO testDTO) {
        return testService.createItem(testDTO);
    }

    @GetMapping
    public List<TestDTO> getAllItems() {
        return testService.getAllItems();
    }

    @PutMapping("/{id}")
    public TestDTO updateItem(@PathVariable Long id, @RequestBody TestDTO testDTO) {
        return testService.updateItem(id, testDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        testService.deleteItem(id);
    }
}
