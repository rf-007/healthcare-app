package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void findDoctorOnClick(View view) {
        startActivity(new Intent(HomePageActivity.this, SearchDoctorActivity.class));
    }

    public void bookAppointmentOnClick(View view) {
        startActivity(new Intent(HomePageActivity.this, BookAppointment.class));
    }

}