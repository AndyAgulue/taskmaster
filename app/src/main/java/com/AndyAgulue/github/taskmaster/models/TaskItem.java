package com.AndyAgulue.github.taskmaster.models;



public class TaskItem {
    String title;
    String body;

    public TaskItem(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }
}
