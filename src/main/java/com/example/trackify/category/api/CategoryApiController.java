package com.example.trackify.category.api;

import com.example.trackify.category.domain.Category;
import com.example.trackify.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks/{task_sequence}/categories")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;

    //카테고리 생성
    @PostMapping("")
    public Category createCategory(
            @PathVariable("task_sequence") Long taskSequence,
            @RequestBody Category category
    ){
        return categoryService.createCategory(taskSequence,category);
    }
    //카테고리 목록 조회
    @GetMapping("/all")
    public List<Category> categories(){
        return categoryService.findAll();
    }
    //카테고리 수정
    @PatchMapping("/{category_sequence}")
    public Category updateCategory(
            @PathVariable("category_sequence") Long categorySequence,
            @RequestBody Category category
    ){
        return categoryService.updateCategory(categorySequence,category);
    }
    //카테고리 상태 변경
    @PatchMapping("/status/{category_sequence}")
    public Category updateCategoryStatus(
            @PathVariable("category_sequence") Long categorySequence,
            @RequestBody Category category
    ){
        return categoryService.updateCategoryStatus(categorySequence,category);
    }
    //카테고리 삭제
    @DeleteMapping("/{category_sequence}")
    public void deleteCategory(
            @PathVariable("category_sequence") Long categorySequence
    ){
        categoryService.deleteCategory(categorySequence);
    }
}
