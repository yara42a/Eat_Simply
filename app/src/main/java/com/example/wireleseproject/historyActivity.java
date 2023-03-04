package com.example.wireleseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class historyActivity extends AppCompatActivity {
    private final DatabaseReference myRef=FirebaseDatabase.getInstance().getReference();
    private final List<Profile> profileList=new ArrayList<>();
    androidx.appcompat.widget.Toolbar back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final RecyclerView recyclerView=findViewById(R.id.UserInfo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(historyActivity.this));
        back=findViewById(R.id.toolBar);

        back.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(historyActivity.this, CalculateActivity.class);
                startActivity(intent);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //profileList.clear();
                for(DataSnapshot History : snapshot.child("History").getChildren()){
                    if(History.hasChild("month")&&History.hasChild("height")&&History.hasChild("weight")&&History.hasChild("calories")){
                        final String getMonth="Month: "+History.child("month").getValue(String.class);
                        final String getHeight="Height: "+History.child("height").getValue(String.class);
                        final String getWeight="Weight: " +History.child("weight").getValue(String.class);
                        final String getCalories="Calories: "+History.child("calories").getValue(String.class);

                        Profile profile=new Profile(getMonth,getHeight,getWeight,getCalories);
                        profileList.add(profile);
                    }
                }
                recyclerView.setAdapter(new MyAdapter(profileList,historyActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}