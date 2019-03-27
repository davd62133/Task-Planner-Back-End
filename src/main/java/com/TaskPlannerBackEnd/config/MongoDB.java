package com.TaskPlannerBackEnd.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDB {

    static public MongoDatabase db;
    @Bean
    public void connectMongoDB(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://david:david@cluster0-xb3tt.mongodb.net/taskplanner?retryWrites=true");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        //database.createCollection("users");
        db = database;
    }
}
