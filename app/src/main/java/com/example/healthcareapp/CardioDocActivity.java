package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.healthcareapp.databinding.ActivityCardioDocBinding;
import com.example.healthcareapp.databinding.ActivityMainBinding;

public class CardioDocActivity extends AppCompatActivity {

    ActivityCardioDocBinding activityCardioDocBinding;
    CardioDBHelper cardioDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCardioDocBinding = ActivityCardioDocBinding.inflate(getLayoutInflater());
        setContentView(activityCardioDocBinding.getRoot());
        cardioDBHelper = new CardioDBHelper(this);
        SQLiteDatabase sqLiteDatabase = cardioDBHelper.getWritableDatabase();


    }

    public void bookappointOnClick(View view) {
        startActivity(new Intent(getApplicationContext(), BookAppointment.class));
    }
}