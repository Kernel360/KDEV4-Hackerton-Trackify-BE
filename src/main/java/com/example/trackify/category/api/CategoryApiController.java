package com.example.trackify.category.api;

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
            @PathVariable Long taskSequence,
            @RequestBody Category category
    ){
        return categoryService.createCategory(taskSequence,category);
    }

    //카테고리 수정
    @PatchMapping("/{category_sequence}")
    public Category updateCategory(
            @PathVariable Long categorySequence,
            @RequestBody Category category
    ){
        return categoryService.updateCategory(categorySequence,category);
    }
    //카테고리 상태 변경
    @PatchMapping("/{categorySequence}")
    public Category updateCategoryStatus(
            @PathVariable Long categorySequence,
            @RequestBody Category category
    ){
        return categoryService.updateCategoryStatus(categorySequence,category);
    }
    //카테고리 삭제
    @DeleteMapping("/{categorySequence}")
    public void deleteCategory(
            @PathVariable Long categorySequence
    ){
        categoryService.deleteCategory(categorySequence);
    }
}
