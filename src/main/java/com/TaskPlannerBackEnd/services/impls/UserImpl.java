package com.TaskPlannerBackEnd.services.impls;

import com.TaskPlannerBackEnd.model.User;
import com.TaskPlannerBackEnd.services.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserImpl implements UserService {
    List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsersList() {
        return users;
    }

    @Override
    public User getUserById(String id) {
        User user = null;
        for (User u : users){
            if(u.getUsername().equals(id)) user = u;
        }
        return user;
    }

    @Override
    public boolean createUser(User user) {
        boolean add = true;
        for(User u:users){
            if(u.getUsername().equals(user.getUsername())) add = false;
        }
        if(add) users.add(user);
        return add;
    }

    @Override
    public void updateUser(User user) {
        int i = 0;
        int pos = 0;
        boolean found = false;
        for(User u:users){
            if(u.getUsername().equals(user.getUsername())){
                pos = i;
                found = true;
            }
            i++;
        }
        if(found) {
            users.set(pos, user);
        }
    }

    @Override
    public void removeUser(String userId) {
        int i = 0;
        int pos = 0;
        boolean found = false;
        for(User u:users){
            i++;
            if(u.getUsername().equals(userId)){
                pos = i;
                found = true;
            }
        }
        if(found) {
            users.remove(pos);
        }
    }

    @Override
    public boolean authorizeUser(String id, String password ) {
        boolean authorize = false;
        for(User u : users){
            if(u.getUsername().equals(id) && u.getPassword().equals(password)) authorize=true;
        }
        return authorize;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = null;
        for(User u : users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) user=u;
        }
        return user;
    }
}
