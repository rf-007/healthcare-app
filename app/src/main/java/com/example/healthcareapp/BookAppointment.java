package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthcareapp.databinding.ActivityBookAppointmentBinding;

public class BookAppointment extends AppCompatActivity {
    ActivityBookAppointmentBinding activityBookAppointmentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBookAppointmentBinding = ActivityBookAppointmentBinding.inflate(getLayoutInflater());
        setContentView(activityBookAppointmentBinding.getRoot());

    }
}