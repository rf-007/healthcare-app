package com.example.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegDBHelper extends SQLiteOpenHelper {

    public final String DBNAME = "reg.db";

    public RegDBHelper(Context context){
        super(context, "reg.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase RegDB) {
        RegDB.execSQL("create table person(nameFull TEXT primary key, phoneNum TEXT, dob TEXT, emailAdd TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase RegDB, int i, int i1) {
        RegDB.execSQL("drop Table if exists person");
    }

    public Boolean insertUser(String nameFull, String phoneNum, String dob, String emailAdd ){
        SQLiteDatabase RegDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameFull", nameFull);
        contentValues.put("phoneNum", phoneNum);
        contentValues.put("dob", dob);
        contentValues.put("emailAdd", emailAdd);
        long res = RegDB.insert("person", null, contentValues);
        if (res == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean nameverify(String nameFull){
        SQLiteDatabase RegDB = this.getWritableDatabase();
        Cursor cursor  = RegDB.rawQuery("select * from person where nameFull = ?",new String[]{nameFull});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
