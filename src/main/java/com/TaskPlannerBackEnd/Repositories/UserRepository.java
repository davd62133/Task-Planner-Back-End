package com.TaskPlannerBackEnd.Repositories;

import com.TaskPlannerBackEnd.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsernameAndPassword(String username,String password);

    User findByUsername(String username);


}
