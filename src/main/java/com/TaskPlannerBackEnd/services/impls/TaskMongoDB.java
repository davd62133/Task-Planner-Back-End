package com.TaskPlannerBackEnd.services.impls;

import com.TaskPlannerBackEnd.Repositories.UserRepository;
import com.TaskPlannerBackEnd.model.Task;
import com.TaskPlannerBackEnd.model.User;
import com.TaskPlannerBackEnd.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskMongoDB implements TaskService {

    @Autowired
    UserRepository ur;

    @Override
    public List<Task> getTaskList() {
        return null;
    }

    @Override
    public Task getTaskById(String id) {
        return null;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return ur.findByUsername(userId).getTaskList();
    }

    @Override
    public void assignTaskToUser(Task task, String userId) {
        User user =ur.findByUsername(userId);
        user.addTask(task);
        ur.save(user);
    }

    @Override
    public void removeTask(String taskId) {

    }

    @Override
    public void updateTask(Task task, String userId) {
        int pos = 0;
        User user = ur.findByUsername(userId);
        List<Task> list = user.getTaskList();
        for(Task t:list){
            if(t.getId().equals(task.getId())) t = task;
        }
        ur.save(user);
    }
}
