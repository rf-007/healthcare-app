package com.example.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AptDBHelper extends SQLiteOpenHelper {
    public final String DBNAME = "apt.db";

    public AptDBHelper(Context context){
        super(context, "apt.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase AptDB) {
        AptDB.execSQL("create table appointment(fullName TEXT primary key, address TEXT, phoneNumber TEXT, date TEXT, time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase AptDB, int i, int i1) {
        AptDB.execSQL("drop Table if exists appointment");
    }

    public Boolean insertAppointment(String fullName, String address, String phoneNumber, String date, String time){
        SQLiteDatabase AptDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullName", fullName);
        contentValues.put("address", address);
        contentValues.put("phoneNumber", phoneNumber);
        contentValues.put("date", date);
        contentValues.put("time", time);
        long res = AptDB.insert("appointment", null, contentValues);
        if (res == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean aptverify(String fullName){
        SQLiteDatabase AptDB = this.getWritableDatabase();
        Cursor cursor  = AptDB.rawQuery("select * from appointment where fullName = ?",new String[]{fullName});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
