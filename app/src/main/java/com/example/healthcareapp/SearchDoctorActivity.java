package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthcareapp.databinding.ActivitySearchDoctorBinding;

public class SearchDoctorActivity extends AppCompatActivity {

    ActivitySearchDoctorBinding activitySearchDoctorBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchDoctorBinding = ActivitySearchDoctorBinding.inflate(getLayoutInflater());
        setContentView(activitySearchDoctorBinding.getRoot());
    }

    public void cardioOnClick(View view) {
        startActivity(new Intent(SearchDoctorActivity.this, CardioDocActivity.class));
    }

    public void dentistOnClick(View view) {
        startActivity(new Intent(SearchDoctorActivity.this, DentistActivity.class));
    }

    public void dieticianOnClick(View view) {
        startActivity(new Intent(SearchDoctorActivity.this, DietActivity.class));
    }

    public void famDocOnClick(View view) {
        startActivity(new Intent(SearchDoctorActivity.this, FamDocActivity.class));
    }
}