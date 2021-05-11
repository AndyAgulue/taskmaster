package com.AndyAgulue.github.taskmaster.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.AndyAgulue.github.taskmaster.R;
import com.amplifyframework.datastore.generated.model.TaskItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    List<TaskItem> taskItems;
    public OnClickable onClickable;
    public TaskAdapter(List<TaskItem> taskItems, OnClickable onClickable){
        this.taskItems = taskItems;
        this.onClickable = onClickable;
    };
    @NonNull
    @NotNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View fragment = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.fragment_task_fragment, parent, false);
        TaskViewHolder vh = new TaskViewHolder(fragment);
        vh.itemView.setOnClickListener(v -> onClickable.handleClickOnTask(vh));
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskViewHolder holder, int position) {
        holder.taskItem = taskItems.get(position);
        String title = holder.taskItem.getTitle();
        ((TextView)holder.itemView.findViewById(R.id.taskFragmentTitle)).setText(title);
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        public TaskItem taskItem;
        public TaskViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
    public interface OnClickable{
        void handleClickOnTask(TaskViewHolder vh);
    }
}