package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.healthcareapp.databinding.ActivityCardioDocBinding;
import com.example.healthcareapp.databinding.ActivityMainBinding;

public class CardioDocActivity extends AppCompatActivity {

    ActivityCardioDocBinding activityCardioDocBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCardioDocBinding = ActivityCardioDocBinding.inflate(getLayoutInflater());
        setContentView(activityCardioDocBinding.getRoot());
    }
}