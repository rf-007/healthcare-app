package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.healthcareapp.databinding.ActivityFamDocBinding;

public class FamDocActivity extends AppCompatActivity {

    ActivityFamDocBinding activityFamDocBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFamDocBinding = ActivityFamDocBinding.inflate(getLayoutInflater());
        setContentView(activityFamDocBinding.getRoot());
    }
}