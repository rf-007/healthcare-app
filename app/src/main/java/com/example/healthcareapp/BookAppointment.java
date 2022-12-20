package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BookAppointment extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.tv1);
        ed1= findViewById(R.id.fullName);
        ed2=findViewById(R.id.address);
        ed3=findViewById(R.id.phoneNumber);
        ed4=findViewById(R.id.fees_1);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);


        Intent it = getIntent();
        String tv1 = it.getStringExtra("text1");
        String fullName = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String phoneNumber = it.getStringExtra("text4");
        String fees_1 = it.getStringExtra("text5");


        tv.setText(tv1);
        ed1.setText(fullName);
        ed2.setText(address);
        ed3.setText(phoneNumber);
        ed4.setText(fees_1);


    }
}