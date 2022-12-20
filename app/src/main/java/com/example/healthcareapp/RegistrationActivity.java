package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.healthcareapp.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding activityRegistrationBinding;

    EditText nameFull, phoneNum, dob, emailAdd;
    Button buttonBtn;
    RegDBHelper RegDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegistrationBinding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(activityRegistrationBinding.getRoot());

        nameFull = (EditText) findViewById(R.id.nameFull);
        phoneNum = (EditText) findViewById(R.id.phoneNum);
        dob = (EditText) findViewById(R.id.dob);
        emailAdd = (EditText) findViewById(R.id.emailAdd);
        buttonBtn = (Button) findViewById(R.id.buttonBtn);
        RegDB = new RegDBHelper(this);

        buttonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameFull.getText().toString();
                String phone = phoneNum.getText().toString();
                String birthDate = dob.getText().toString();
                String email = emailAdd.getText().toString();

                if(name.equals("") || phone.equals("") || birthDate.equals("") || email.equals("")) {
                    Toast.makeText(RegistrationActivity.this, "Enter all the values in the field", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean ress = RegDB.nameverify(name);
                    if(ress == false)
                    {
                        Boolean res = RegDB.insertUser(name, phone, birthDate, email);
                        if(res==true)
                        {
                            Toast.makeText(RegistrationActivity.this,"Registration Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(RegistrationActivity.this,"Sorry, Registration Failed. Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this, "User Exists. Welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }

    public void findDoctor(View view) {
        startActivity(new Intent(RegistrationActivity.this, SearchDoctorActivity.class));
    }

}