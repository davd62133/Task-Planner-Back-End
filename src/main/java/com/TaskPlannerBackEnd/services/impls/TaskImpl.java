package com.TaskPlannerBackEnd.services.impls;

import com.TaskPlannerBackEnd.model.Task;
import com.TaskPlannerBackEnd.model.User;
import com.TaskPlannerBackEnd.services.TaskService;
import com.TaskPlannerBackEnd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskImpl implements TaskService {
    @Autowired
    UserService userService;
    @Override
    public List<Task> getTaskList() {
        List<Task> tasks = new ArrayList<>();
        for(User u : userService.getUsersList()){
            for(Task t : u.getTaskList()){
                tasks.add(t);
            }
        }
        return tasks;
    }

    @Override
    public Task getTaskById(String id) {
        Task task = null;
        for(User u:userService.getUsersList()){
            for(Task t:u.getTaskList()){
                if(t.getId().equals(id)) task=t;
            }
        }
        return task;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return userService.getUserById(userId).getTaskList();
    }

    @Override
    public void assignTaskToUser(Task task, String userId) {
        userService.getUserById(userId).addTask(task);
    }

    @Override
    public void removeTask(String taskId) {
        for(User u:userService.getUsersList()){
            int i = 0;
            int pos = 0;
            boolean found = false;
            for(Task t:u.getTaskList()){
                if(t.getId().equals(taskId)){
                    pos = i;
                    found = true;
                }
                i++;
            }
            if(found) u.getTaskList().remove(pos);
        }
    }

    @Override
    public void updateTask(Task task) {
        for(User u:userService.getUsersList()){
            int i = 0;
            int pos = 0;
            boolean found = false;
            for(Task t:u.getTaskList()){
                if(t.getId().equals(task.getId())){
                    pos = i;
                    found = true;
                }
                i++;
            }
            if(found) u.getTaskList().set(pos,task);
        }
    }
}
