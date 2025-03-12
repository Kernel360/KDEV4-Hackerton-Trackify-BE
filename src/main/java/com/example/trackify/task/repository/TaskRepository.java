package com.example.trackify.task.repository;

import com.example.trackify.task.domain.Task;
import com.example.trackify.task.domain.TaskStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final EntityManager em;

    @Transactional
    public void save(Task task) {
        em.persist(task);
    }

    public Task findOne(Long taskSequence) {
        return em.find(Task.class, taskSequence);
    }

    public List<Task> findAll() {
        return em.createQuery("select t from Task t", Task.class).getResultList();
    }

    @Transactional
    public void update(Long taskSequence, String taskTitle, LocalDate taskStartDate, LocalDate taskEndDate){
        em.createQuery("update Task t set t.taskTitle = :title, t.taskStartDate = :startDate, t.taskEndDate = :endDate where t.taskSequence = :sequence")
                .setParameter("title", taskTitle)
                .setParameter("startDate", taskStartDate)
                .setParameter("endDate", taskEndDate)
                .setParameter("sequence", taskSequence)
                .executeUpdate();
    }

    @Transactional
    public void updateStatus(Long taskSequence, Integer taskStatus){
        TaskStatus statusEnum = TaskStatus.fromValue(taskStatus);
        em.createQuery("update Task t set t.taskStatus = :status where t.taskSequence = :sequence")
                .setParameter("status", statusEnum)
                .setParameter("sequence", taskSequence)
                .executeUpdate();
    }


    @Transactional
    public void delete(Long taskSequence){
        em.createQuery("delete from Task t where t.taskSequence = :sequence")
                .setParameter("sequence", taskSequence)
                .executeUpdate();
    }
}
