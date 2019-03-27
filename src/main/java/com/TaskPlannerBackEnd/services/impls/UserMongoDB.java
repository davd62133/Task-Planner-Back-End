package com.TaskPlannerBackEnd.services.impls;

import com.TaskPlannerBackEnd.Repositories.UserRepository;
import com.TaskPlannerBackEnd.config.MongoDB;
import com.TaskPlannerBackEnd.model.User;
import com.TaskPlannerBackEnd.services.UserService;
import com.mongodb.BasicDBObject;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Service
public class UserMongoDB implements UserService{

    @Autowired
    UserRepository ur;

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
        if(ur.findByUsername(user.getUsername())==null){
            ur.save(user);
            return true;
        }else{
            return false;
        }
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
        return ur.findByUsernameAndPassword(username,password);
    }
}
