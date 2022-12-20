package com.example.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class OrdersDatabaseHelper extends SQLiteOpenHelper{

    public static final String DBNAME = "OrdersDB.db";

    public OrdersDatabaseHelper(Context context){
        super(context, "OrdersDB.db",  null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Orders(namefull TEXT primary key , date TEXT, Hosp_name TEXT, medicines TEXT , total FLOAT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1 ) {

        MyDB.execSQL("drop Table if exists person");

    }

    public Boolean insertOrders(String username, String date, String hospital_name, String medicines, String total){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("namefull",username);
        contentValues.put("date",date);
        contentValues.put("Hosp_name",hospital_name);
        contentValues.put("medicines",medicines);
        contentValues.put("total",total);

        long result = MyDB.insert("Orders",null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean getOrderDetails(String username){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where namefull = ?",new String[]{username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }


}




