package com.example.trackify.task.repository;

import com.example.trackify.task.domain.Task;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
    private final EntityManager em;

    public void save(Task task) {
        em.persist(task);
    }

    public Task findOne(BigInteger taskSequence) {
        return em.find(Task.class, taskSequence);
    }

    public List<Task> findAll() {
        return em.createQuery("select t from Task t", Task.class).getResultList();
    }

    public void update(BigInteger taskSequence, String taskTitle, LocalDate taskStartDate, LocalDate taskEndDate){
        em.createQuery("update Task t set t.taskTitle = :title, t.taskStartDate = :startDate, t.taskEndDate = :endDate where t.taskSequence = :sequence", Task.class)
                .setParameter("title", taskTitle)
                .setParameter("startDate", taskStartDate)
                .setParameter("endDate", taskEndDate)
                .setParameter("sequence", taskSequence)
                .executeUpdate();
    }

    public void updateStatus(BigInteger taskSequence, Integer taskStatus){
        em.createQuery("update Task t set t.taskStatus = :status where t.taskSequence = :sequence", Task.class)
                .setParameter("status", taskStatus)
                .setParameter("sequence", taskSequence)
                .executeUpdate();
    }

    public void delete(BigInteger taskSequence){
        em.createQuery("delete from Task t where t.taskSequence = :sequence", Task.class)
                .setParameter("sequence", taskSequence)
                .executeUpdate();
    }
}
