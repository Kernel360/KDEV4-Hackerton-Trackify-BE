package com.example.trackify.todo.service;

import com.example.trackify.category.domain.Category;
import com.example.trackify.category.repository.CategoryRepository;
import com.example.trackify.category.service.CategoryService;
import com.example.trackify.todo.domain.Todo;
import com.example.trackify.todo.domain.TodoStatus;
import com.example.trackify.todo.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final CategoryService categoryService;

    //Todo 등록
    public Todo createTodo(Long categorySequence, Todo todo){
        Optional<Category> category = categoryService.findById(categorySequence);

        todo.setCategory(category.get());
        return todoRepository.save(todo);
    }
    //Todo 조회
    public Optional<Todo> findById(Long todoSequence){
        return todoRepository.findById(todoSequence);
    }
    public List<Todo> findAll(){
        return todoRepository.findAll();
    }
    //Todo 수정
    public Todo updateTodo(Long todoSequence, Todo todo){
        Optional<Todo> savedTodo = todoRepository.findById(todoSequence);
        savedTodo.get().setTodoWork(todo.getTodoWork());
        return todoRepository.save(savedTodo.get());
    }
    //Todo 상태 변경
    public Todo updateTodoStatus(Long todoSequence, Boolean todoStatus){
        Todo savedTodo = todoRepository.findById(todoSequence)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + todoSequence));

        savedTodo.setTodoCheck(TodoStatus.fromBoolean(todoStatus));
        return todoRepository.save(savedTodo);
    }
    //Todo 삭제
    public void deleteTodo(Long todoSequence){
        Optional<Todo> todo = findById(todoSequence);
        todoRepository.delete(todo.get());
    }
}
