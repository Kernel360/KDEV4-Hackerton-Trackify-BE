package com.example.trackify.task.controller;

import com.example.trackify.task.domain.Task;
import com.example.trackify.task.domain.TaskForm;
import com.example.trackify.task.domain.TaskStatus;
import com.example.trackify.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    //태스크 생성
    @PostMapping("/tasks/new")
    public ResponseEntity<Map<Long, String>> createTask(
            @RequestBody TaskForm form
    ) {
        //Task 엔티티 생성
        Task task = Task.builder()
                .taskTitle(form.getTaskTitle())
                .taskStartDate(form.getTaskStartDate())
                .taskEndDate(form.getTaskEndDate())
                .build();

        //Task 서비스에서 저장
        taskService.save(task);

        //응답을 Map -> JSON 형태로 반환
        Map<Long, String> res = new HashMap<>();
        res.put(task.getTaskSequence(), "태스크 등록 완료");

        return ResponseEntity.ok(res);
    }

    //태스크 목록 조회
    @GetMapping("/tasks/all")
    public ResponseEntity<List<Task>> showAllTasks() {
        List<Task> res = taskService.findAll().stream().toList();
        return ResponseEntity.ok(res);
    }

    //태스크 상세 조회
    @GetMapping("/tasks/{task_sequence}")
    public ResponseEntity<Task> getDetailTask(
            @PathVariable Long taskSequence
    ) {
        Task res = taskService.findOne(taskSequence);
        return ResponseEntity.ok(res);
    }

    //태스크 수정
    @PatchMapping("/tasks/{task_sequence}")
    public ResponseEntity<Map<String, String>> updateTask(
            @RequestBody TaskForm form,
            @PathVariable Long taskSequence
    ) {
        String taskTitle = form.getTaskTitle();
        LocalDate taskStartDate = form.getTaskStartDate();
        LocalDate taskEndDate = form.getTaskEndDate();

        taskService.update(taskSequence, taskTitle, taskStartDate, taskEndDate);

        Map<String, String> res = new HashMap<>();
        res.put("message", "태스크 수정 완료");
        return ResponseEntity.ok(res);
    }

    //태스크 상태 변경
    @PatchMapping("/tasks/{task_sequence}")
    public ResponseEntity<Map<String, String>> updateTaskStatus(
            @RequestBody TaskStatus taskStatus,
            @PathVariable Long taskSequence
    ){
        taskService.updateStatus(taskSequence, taskStatus.getValue());

        Map<String, String> res = new HashMap<>();
        res.put("message", "태스크 상태 변경 완료");
        return ResponseEntity.ok(res);
    }

    //태스크 삭제
    @DeleteMapping("/tasks/{task_sequence}")
    public ResponseEntity<Map<String, String>> deleteTask(
            @PathVariable Long taskSequence
    ) {

        taskService.delete(taskSequence);

        Map<String, String> res = new HashMap<>();
        res.put("message", "태스크 삭제 완료");
        return ResponseEntity.ok(res);
    }
}