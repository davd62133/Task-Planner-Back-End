package com.TaskPlannerBackEnd.services;

import com.TaskPlannerBackEnd.model.Task;
import com.TaskPlannerBackEnd.model.User;

import java.util.List;

public interface TaskService {
    List<Task> getTaskList();
    Task getTaskById(String id);
    List<Task> getTasksByUserId(String userId);
    void assignTaskToUser(Task task, String userId);
    void removeTask(String taskId);
    void updateTask(Task task, String userId);
}
