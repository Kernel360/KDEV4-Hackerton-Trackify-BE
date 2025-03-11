package com.example.trackify.category.controller;

import com.example.trackify.category.domain.Category;
import com.example.trackify.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks/{task_sequence}/categories")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;

    //카테고리 생성
    @PostMapping("")
    public Category createCategory(
            @PathVariable Long task_sequence,
            @RequestBody Category category
    ){
        return categoryService.createCategory(task_sequence,category);
    }

    //카테고리 수정
    @PatchMapping("/{category_sequence}")
    public Category updateCategory(
            @PathVariable Long task_sequence,
            @PathVariable Long category_sequence,
            @RequestBody Category category
    ){
        return categoryService.updateCategory(category_sequence,category);
    }
    //카테고리 상태 변경
    @PatchMapping("/{category_sequence}")
    public Category updateCategoryStatus(
            @PathVariable Long category_sequence,
            @RequestBody Category category
    ){
        return categoryService.updateCategoryStatus(category_sequence,category);
    }
    //카테고리 삭제
    @DeleteMapping("/{category_sequence}")
    public void deleteCategory(
            @PathVariable Long category_sequence
    ){
        categoryService.deleteCategory(category_sequence);
    }
}
