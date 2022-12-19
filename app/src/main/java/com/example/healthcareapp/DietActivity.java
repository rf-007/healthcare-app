package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.healthcareapp.databinding.ActivityDietBinding;

public class DietActivity extends AppCompatActivity {

    ActivityDietBinding activityDietBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDietBinding = ActivityDietBinding.inflate(getLayoutInflater());
        setContentView(activityDietBinding.getRoot());
    }
}