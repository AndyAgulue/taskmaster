package com.AndyAgulue.github.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.AndyAgulue.github.taskmaster.daos.TaskItemDao;
import com.AndyAgulue.github.taskmaster.models.TaskItem;

public class AddTask extends AppCompatActivity {

    TaskmasterDatabase taskmasterDatabase;
    String title;
    String description;

     static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskmasterDatabase = Room.databaseBuilder(getApplicationContext(), TaskmasterDatabase.class, "aagulue_task_master")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        Button addSubmitATask = findViewById(R.id.submitATask);


        addSubmitATask.setOnClickListener(new View.OnClickListener() {
                @Override
                   public void onClick(View v){
                    ((TextView) findViewById(R.id.textView4)).setText("Submitted");

                    TaskItem taskItem = new TaskItem(title, description);
                    taskmasterDatabase.taskItemDao().insert(taskItem);
                }


        });
    }
}

//  @override
// protected void onResume() {
//      super.onResume();