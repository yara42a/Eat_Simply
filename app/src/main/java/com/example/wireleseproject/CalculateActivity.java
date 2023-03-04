package com.example.wireleseproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalculateActivity extends AppCompatActivity {
    Button Female, Male,calc,history;
    ImageButton back;
    EditText month, heigh, weigh, Age, Calories;
    float h, w, calories;
    int age;
    private FirebaseDatabase database=FirebaseDatabase.getInstance();
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        month =findViewById(R.id.Month);
        heigh =findViewById(R.id.height);
        weigh = findViewById(R.id.weight);
        Age =findViewById(R.id.Age);
        Male =findViewById(R.id.male);
        Female =findViewById(R.id.female);
        Calories =findViewById(R.id.result);
        calc=findViewById(R.id.calc);
        history=findViewById(R.id.history);
        back=findViewById(R.id.back);
        myRef=FirebaseDatabase.getInstance().getReference().child("History");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calories.setText(null);
                h = Float.parseFloat(heigh.getText() + "");
                w = Float.parseFloat(weigh.getText() + "");
                age = Integer.parseInt(Age.getText() + "");
                calories = (float) ((10 * w) + (6.25 * h) - (5 * age) + 5);
                Calories.setText(String.valueOf(calories));
            }
        });
        Female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calories.setText(null);
                h = Float.parseFloat(heigh.getText() + "");
                w = Float.parseFloat(weigh.getText() + "");
                age = Integer.parseInt(Age.getText() + "");

                calories = (float) ((10 * w) + (6.25 * h) - (5 * age) - 161);
                Calories.setText(String.valueOf(calories));
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserHistory();

            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculateActivity.this, historyActivity.class));
            }
        });
    }

    private void inserHistory() {
        String Month=month.getText().toString();
        String height=heigh.getText().toString();
        String weight=weigh.getText().toString();
        String calories=Calories.getText().toString();

        Profile profile=new Profile(Month,height,weight,calories);

        myRef.push().setValue(profile);
        Toast.makeText(CalculateActivity.this,"Data inserted!",Toast.LENGTH_SHORT).show();
    }
}
