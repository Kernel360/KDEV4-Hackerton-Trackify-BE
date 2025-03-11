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
    public Category createCategory(Long taskSequence, Category category){
        Task task = taskRepository.findOne(taskSequence);

        category.setTask(task);
        return categoryRepository.save(category);
    }
    //카테고리 조회
    public Optional<Category> findById(Long categorySequence){
        return categoryRepository.findById(categorySequence);
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    //카테고리 수정
    public Category updateCategory(Long categorySequence,Category category){
        Optional<Category> savedCategory = categoryRepository.findById(categorySequence);
        savedCategory.get().setCategoryName(category.getCategoryName());
        savedCategory.get().setCategoryGoalTime(category.getCategoryGoalTime());
        return categoryRepository.save(savedCategory.get());
    }

    //카테고리 상태 변경
    public Category updateCategoryStatus(Long categorySequence,Category category) {
        Optional<Category> savedCategory = categoryRepository.findById(categorySequence);
        savedCategory.get().setCategoryStatus(category.getCategoryStatus());
        return categoryRepository.save(savedCategory.get());
    }

    //카테고리 삭제
    public void deleteCategory(Long categorySequence){
        Optional<Category> category = categoryRepository.findById(categorySequence);
        categoryRepository.delete(category.get());
    }
}
