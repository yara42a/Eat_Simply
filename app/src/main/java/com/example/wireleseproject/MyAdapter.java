package com.example.wireleseproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<Profile> prof;
    private Context context;

    public MyAdapter(List<Profile> prof, Context context) {
        this.prof = prof;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Profile profile=prof.get(position);

        holder.Month.setText(profile.getMonth());
        holder.height.setText(profile.getHeight());
        holder.weight.setText(profile.getWeight());
        holder.calories.setText(profile.getCalories());

    }

    @Override
    public int getItemCount() {
        return prof.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView Month,height,weight,calories;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            Month=itemView.findViewById(R.id.Month);
            height=itemView.findViewById(R.id.height);
            weight=itemView.findViewById(R.id.weight);
            calories=itemView.findViewById(R.id.calories);
        }
    }
}
