package com.ll.exam.todoappg.service;

import com.ll.exam.todoappg.exception.ResourceNotFoundException;
import com.ll.exam.todoappg.model.Task;
import com.ll.exam.todoappg.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }

        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
//            existingTask.setTitle(updatedTask.getTitle());
//            existingTask.setDescription(updatedTask.getDescription());
//            existingTask.setDueDate(updatedTask.getDueDate());
//            existingTask.setCompleted(updatedTask.isCompleted());

            return taskRepository.save(existingTask);
        } else {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }
}
