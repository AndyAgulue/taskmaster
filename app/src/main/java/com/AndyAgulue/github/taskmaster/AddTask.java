package com.AndyAgulue.github.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addSubmitATask = findViewById(R.id.submitATask);
        addSubmitATask.setOnClickListener( new View.OnClickListener() {
                @Override
                   public void onClick(View v){
                    ((TextView) findViewById(R.id.textView4)).setText("Submitted");
                }
        });
    }
}