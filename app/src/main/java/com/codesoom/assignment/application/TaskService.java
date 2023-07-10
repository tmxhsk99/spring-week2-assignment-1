package com.codesoom.assignment.application;

import com.codesoom.assignment.exception.custom.TaskNotFound;
import com.codesoom.assignment.models.domain.Task;
import com.codesoom.assignment.models.request.TaskCreate;
import com.codesoom.assignment.models.request.TaskEdit;
import com.codesoom.assignment.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskCreate task) {
        return taskRepository.save(task.toTask());
    }

    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(TaskNotFound::new);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(TaskNotFound::new);
        taskRepository.delete(task);
    }

    public Task updateTask(TaskEdit task) {
        return taskRepository.update(task.toTask());
    }
}
