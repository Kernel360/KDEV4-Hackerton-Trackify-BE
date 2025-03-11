package com.example.trackify.category.service;

import com.example.trackify.category.domain.Category;
import com.example.trackify.category.repository.CategoryRepository;
import com.example.trackify.task.domain.Task;
import com.example.trackify.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;

    //카테고리 생성
    public Category createCategory(Long task_sequence, Category category){
        Task task = taskRepository.findOne(task_sequence);

        category.setTask(task);
        return categoryRepository.save(category);
    }

    //카테고리 수정
    public Category updateCategory(Long category_sequence,Category category){
        Optional<Category> savedCategory = categoryRepository.findById(category_sequence);
        savedCategory.get().setCategoryName(category.getCategoryName());
        savedCategory.get().setCategoryGoalTime(category.getCategoryGoalTime());
        return categoryRepository.save(savedCategory.get());
    }

    //카테고리 상태 변경
    public Category updateCategoryStatus(Long category_sequence,Category category) {
        Optional<Category> savedCategory = categoryRepository.findById(category_sequence);
        savedCategory.get().setCategoryStatus(category.getCategoryStatus());
        return categoryRepository.save(savedCategory.get());
    }

    //카테고리 삭제
    public void deleteCategory(Long category_sequence){
        Optional<Category> category = categoryRepository.findById(category_sequence);
        categoryRepository.delete(category.get());
    }
}
