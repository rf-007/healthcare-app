package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthcareapp.databinding.ActivityDentistBinding;

public class DentistActivity extends AppCompatActivity {

    ActivityDentistBinding activityDentistBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDentistBinding = ActivityDentistBinding.inflate(getLayoutInflater());
        setContentView(activityDentistBinding.getRoot());
    }

    public void dentistOnClick(View view) {
        startActivity(new Intent(getApplicationContext(), BookAppointment.class));
    }
}