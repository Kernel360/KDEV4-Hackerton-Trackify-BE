package com.example.trackify.todo.api;

import com.example.trackify.todo.domain.Todo;
import com.example.trackify.todo.domain.TodoStatusUpdateRequest;
import com.example.trackify.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks/{task_sequence}/categories/{category_sequence}/todos")
@RequiredArgsConstructor
public class TodoApiController {

    private final TodoService todoService;

    //Todo 등록
    @PostMapping("")
    public Todo createTodo(
            @PathVariable("category_sequence") Long categorySequence,
            @RequestBody Todo todo
    ){
        return todoService.createTodo(categorySequence,todo);
    }
    //Todo 상세 조회
    @GetMapping("/{todo_sequence}")
    public Optional<Todo> findById(
            @PathVariable("todo_sequence") Long todoSequence
    ){
        return todoService.findById(todoSequence);
    }
    //Todo 목록 조회
    @GetMapping("")
    public List<Todo> findAll(){
        return todoService.findAll();
    }
    //Todo 수정
    @PatchMapping("/{todo_sequence}")
    public Todo updateTodo(
            @PathVariable("todo_sequence") Long todoSequence,
            @RequestBody Todo todo
    ){
        return todoService.updateTodo(todoSequence,todo);
    }
    //Todo 상태 변경
    @PatchMapping("/status/{todo_sequence}")
    public Todo updateTodoStatus(
            @PathVariable("todo_sequence") Long todoSequence,
            @RequestBody TodoStatusUpdateRequest request){
        return todoService.updateTodoStatus(todoSequence,request.getTodoCheck());
    }
    //Todo 삭제
    @DeleteMapping("/{todo_sequence}")
    public void deleteTodo(
            @PathVariable("todo_sequence") Long todoSequence){
        todoService.deleteTodo(todoSequence);
    }
}
