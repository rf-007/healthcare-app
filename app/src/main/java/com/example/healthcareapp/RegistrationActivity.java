package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.healthcareapp.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding activityRegistrationBinding;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegistrationBinding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(activityRegistrationBinding.getRoot());
        radioGroup = (RadioGroup) findViewById(R.id.radioGrp);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
            }
        });
    }

    public void findDoctor(View view) {
        startActivity(new Intent(RegistrationActivity.this, FindDoctorActivity.class));
    }

}