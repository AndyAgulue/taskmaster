package com.AndyAgulue.github.taskmaster.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.AndyAgulue.github.taskmaster.models.TaskItem;

import java.util.List;

@Dao
public interface TaskItemDao {

    @Insert
    public void insert(TaskItem taskItem);

    @Query("SELECT * FROM TaskItem")
    public List<TaskItem> findAll();
}
