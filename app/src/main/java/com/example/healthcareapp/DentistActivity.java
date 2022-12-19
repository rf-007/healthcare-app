package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.healthcareapp.databinding.ActivityDentistBinding;

public class DentistActivity extends AppCompatActivity {

    ActivityDentistBinding activityDentistBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDentistBinding = ActivityDentistBinding.inflate(getLayoutInflater());
        setContentView(activityDentistBinding.getRoot());
    }
}