package com.example.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MedicinesDatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "MedicinesDB.db";

    public MedicinesDatabaseHelper(Context context){
        super(context, "MedicinesDB.db",  null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Medicines(Hosp_name TEXT primary key , med_name TEXT, Chemical TEXT, company TEXT ,price FLOAT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1 ) {

        MyDB.execSQL("drop Table if exists person");

    }

    public Boolean insertMedicines(String hospital_name, String medicine_name, String chemical , String company, Float price){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Hosp_name",hospital_name);
        contentValues.put("med_name",medicine_name);
        contentValues.put("Chemical",chemical);
        contentValues.put("company",company);
        contentValues.put("price",price);

        long result = MyDB.insert("Medicines",null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean getMedicines(String hospital_name){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where Hosp_name = ?",new String[]{hospital_name});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }



}
