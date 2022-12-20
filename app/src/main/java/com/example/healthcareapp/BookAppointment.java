package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.healthcareapp.databinding.ActivityBookAppointmentBinding;

public class BookAppointment extends AppCompatActivity {
    ActivityBookAppointmentBinding activityBookAppointmentBinding;
    AptDBHelper aptDBHelper;
    EditText address,phoneNumber,fullName,date,time;
    Button button_registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBookAppointmentBinding = ActivityBookAppointmentBinding.inflate(getLayoutInflater());
        setContentView(activityBookAppointmentBinding.getRoot());


        fullName = (EditText) findViewById(R.id.fullName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        address = (EditText) findViewById(R.id.address);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        button_registration = (Button) findViewById(R.id.button_registration);
        aptDBHelper =  new AptDBHelper (this);

        button_registration.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name = fullName.getText().toString();
                String phone = phoneNumber.getText().toString();
                String email = address.getText().toString();
                String Dob = date.getText().toString();
                String Tm = time.getText().toString();


                if(name.equals("") || phone.equals("") || email.equals("") || Dob.equals("") || Tm.equals("")) {
                    Toast.makeText(BookAppointment.this, "Enter all the values in the field", Toast.LENGTH_SHORT).show();
                }


                else{
                    Boolean ress = aptDBHelper.aptverify(name);
                    if(ress == false)
                    {
                        Boolean res = aptDBHelper.insertAppointment(name,phone,email,Dob,Tm);
                        if(res==true)
                        {
                            Toast.makeText(BookAppointment.this,"Booking appointment Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(BookAppointment.this,"Sorry, Booking Appointment Failed. Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Booking already exists!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }

        });




    }
}



