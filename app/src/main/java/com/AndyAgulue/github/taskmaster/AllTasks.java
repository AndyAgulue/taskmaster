package com.AndyAgulue.github.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.AndyAgulue.github.taskmaster.adapter.TaskAdapter;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.TaskItem;

import java.util.ArrayList;
import java.util.List;

public class AllTasks extends AppCompatActivity implements TaskAdapter.OnClickable{
    public static String TAG = "aagulue.main";

    List<TaskItem> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);

        RecyclerView recyclerView = findViewById(R.id.TaskRecycleView);
        recyclerView.setAdapter(new TaskAdapter(tasks, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Handler handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        };



        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
            Log.i(TAG, "configured amplify");
        } catch (AmplifyException e) {
            e.printStackTrace();
        }

        Amplify.API.query(
                ModelQuery.list(TaskItem.class),
                response -> {
                    for(TaskItem t: response.getData()){
                        tasks.add(t);
                    }
                    handler.sendEmptyMessage(1);
                },
                response -> {

                }
        );
    }

    @Override
    public void handleClickOnTask(TaskAdapter.TaskViewHolder vh) {

    }
}