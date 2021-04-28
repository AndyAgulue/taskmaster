package com.AndyAgulue.github.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preferenceEditor = preferences.edit();

        String username = preferences.getString("username", null);
        if(username != null) {
            ((TextView) findViewById(R.id.username)).setText(username);
        }

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

        Button buyGroceriesButton = findViewById(R.id.buyGroceries);
        buyGroceriesButton.setOnClickListener(view -> {

            String groceryTask = buyGroceriesButton.getText().toString();
            preferenceEditor.putString("task", groceryTask);
            preferenceEditor.apply();

            Intent intent = new Intent(MainActivity.this, TaskDetail.class);
            startActivity(intent);
        });

        Button walkDogButton = findViewById(R.id.walkDog);
        walkDogButton.setOnClickListener(view -> {

            String walkDogTask = walkDogButton.getText().toString();
            preferenceEditor.putString("task", walkDogTask);
            preferenceEditor.apply();

            Intent intent = new Intent(MainActivity.this, TaskDetail.class);
            startActivity(intent);
        });

        Button sendEmailButton = findViewById(R.id.sendEmails);
        sendEmailButton.setOnClickListener(view -> {

            String emailTask = sendEmailButton.getText().toString();
            preferenceEditor.putString("task", emailTask);
            preferenceEditor.apply();

            Intent intent = new Intent(MainActivity.this, TaskDetail.class);
            startActivity(intent);
        });

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsPage.class);
            startActivity(intent);
        });
    }
}