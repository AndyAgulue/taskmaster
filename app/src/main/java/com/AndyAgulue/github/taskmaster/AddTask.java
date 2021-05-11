package com.AndyAgulue.github.taskmaster;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskItem;

public class AddTask extends AppCompatActivity {

    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        Button addSubmitATask = findViewById(R.id.submitATask);
        addSubmitATask.setOnClickListener(v -> {
            String title = ((EditText) findViewById(R.id.TitleEditText)).getText().toString();
            String description = ((EditText) findViewById(R.id.DescriptionEditText)).getText().toString();
            TaskItem newTaskItem = TaskItem.builder()
                    .title(title)
                    .description(description)
                    .build();
            Amplify.API.mutate(
                    ModelMutation.create(newTaskItem),
                    response -> {
                        Log.i("fromAddTaskPage", "successful");
                    },
                    response -> {
                        Log.i("fromAddTaskPage", "add Task Failed");
                    }
            );
            Intent goHomeIntent = new Intent(AddTask.this, MainActivity.class);
            AddTask.this.startActivity(goHomeIntent);
            startActivity(goHomeIntent);

        });
    }
}

