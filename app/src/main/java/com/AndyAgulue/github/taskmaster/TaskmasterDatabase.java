package com.AndyAgulue.github.taskmaster;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.AndyAgulue.github.taskmaster.daos.TaskItemDao;
import com.AndyAgulue.github.taskmaster.models.TaskItem;

@Database(entities = {TaskItem.class}, version=2)
public abstract class TaskmasterDatabase extends RoomDatabase {
    public abstract TaskItemDao taskItemDao();
}
