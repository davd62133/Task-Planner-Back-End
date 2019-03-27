package com.TaskPlannerBackEnd.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Task {
    String id;
    String description;
    String date;
    String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DBObject getDBObject(){
        return new BasicDBObject("_id",id)
                .append("description",description)
                .append("date",date)
                .append("status",status);
    }
}
