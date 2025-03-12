package com.example.trackify.task.service;

import com.example.trackify.task.domain.Task;
import com.example.trackify.task.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * 태스크 등록
     */
    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    /**
     * 태스크 목록 조회
     */
    @Transactional
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    /**
     * 태스크 상세 조회
     */
    @Transactional
    public Task findOne(Long taskSequence) {
        return taskRepository.findOne(taskSequence);
    }

    /**
     * 태스크 수정 (이름, 시작일, 종료일)
     */
    @Transactional
    public void update(Long taskSequence, String taskTitle, LocalDate taskStartDate, LocalDate taskEndDate) {
        taskRepository.update(taskSequence, taskTitle, taskStartDate, taskEndDate);
    }

    /**
     * 태스크 상태 변경
     */
    @Transactional
    public void updateStatus(Long taskSequence, Integer taskStatus) {
        taskRepository.updateStatus(taskSequence, taskStatus);
    }

    /**
     * 태스크 삭제
     */
    @Transactional
    public void delete(Long taskSequence) {
        taskRepository.delete(taskSequence);
    }
}
