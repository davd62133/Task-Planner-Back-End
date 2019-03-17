package com.TaskPlannerBackEnd.services;

import com.TaskPlannerBackEnd.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();
    User getUserById(String id);
    boolean createUser(User user);
    void updateUser(User user);
    void removeUser(String userId);
    boolean authorizeUser(String id, String password);
    User findUserByUsernameAndPassword(String username, String password);
}
