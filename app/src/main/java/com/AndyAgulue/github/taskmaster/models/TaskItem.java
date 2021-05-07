package com.AndyAgulue.github.taskmaster.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaskItem {
    @PrimaryKey(autoGenerate = true)
    public long id;

    String title;
    String description;

    public TaskItem(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
}
