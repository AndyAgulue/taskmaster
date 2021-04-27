package com.AndyAgulue.github.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTaskButton = findViewById(R.id.addTask);
        addTaskButton.setOnClickListener( view -> {
           Intent goToAddTaskPageIntent = new Intent (MainActivity.this, AddTask.class);
           startActivity(goToAddTaskPageIntent);
        });

        Button allTaskButton = findViewById(R.id.allTasks);
        allTaskButton.setOnClickListener(view -> {
            Intent goToAllTasksPageIntent = new Intent (MainActivity.this, AllTasks.class);
            startActivity(goToAllTasksPageIntent);
        });
    }
}