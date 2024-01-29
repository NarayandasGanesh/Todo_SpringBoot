package com.ll.exam.todoappg.repository;

import com.ll.exam.todoappg.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
