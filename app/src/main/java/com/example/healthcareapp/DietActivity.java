package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthcareapp.databinding.ActivityDietBinding;

public class DietActivity extends AppCompatActivity {

    ActivityDietBinding activityDietBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDietBinding = ActivityDietBinding.inflate(getLayoutInflater());
        setContentView(activityDietBinding.getRoot());
    }

    public void dietOnClick(View view) {
        startActivity(new Intent(getApplicationContext(), BookAppointment.class));
    }
}