package com.AndyAgulue.github.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.AndyAgulue.github.taskmaster.adapter.TaskRecyclerViewAdapter;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskItem;
import com.amplifyframework.datastore.generated.model.taskmaster;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "aagulue.main";

    List<TaskItem> tasks = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
            Log.i(TAG, "configured amplify");
        } catch (AmplifyException e) {
            e.printStackTrace();
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preferenceEditor = preferences.edit();

        String username = preferences.getString("username", null);
        if(username != null) {
            ((TextView) findViewById(R.id.username)).setText(username);
        }

        Amplify.API.query(
                ModelQuery.list(TaskItem.class),
                response -> {
                    for(TaskItem t: response.getData()){
                        tasks.add(t);
                    }
                },
                response -> {

                }
        );

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

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsPage.class);
            startActivity(intent);
        });

        Button signInButton = findViewById(R.id.settingsButton);
        signInButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsPage.class);
            startActivity(intent);
        });

        Button signUpButton = findViewById(R.id.settingsButton);
        signUpButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsPage.class);
            startActivity(intent);
        });

    }
}