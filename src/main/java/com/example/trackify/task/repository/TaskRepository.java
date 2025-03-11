package com.example.trackify.task.repository;

import com.example.trackify.task.domain.Task;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
    private final EntityManager em;

    public void save(Task task) {
        em.persist(task);
    }

    public Task findOne(Long id) {
        return em.find(Task.class, id);
    }

    public List<Task> findAll() {
        return em.createQuery("select t from Task m", Task.class).getResultList();
    }

    public List<Task> findByTitle(String title) {
        return em.createQuery("select t from Task t where t.title = :title", Task.class).setParameter("title", title).getResultList();
    }

}
