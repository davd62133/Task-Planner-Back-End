package com.TaskPlannerBackEnd.services.impls;

import com.TaskPlannerBackEnd.config.MongoDB;
import com.TaskPlannerBackEnd.model.User;
import com.TaskPlannerBackEnd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMongoDB implements UserService {

    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        MongoDB.db.getCollection("users").insertOne(user.getDocument());
        return true;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(String userId) {

    }

    @Override
    public boolean authorizeUser(String id, String password) {
        return false;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return null;
    }
}
