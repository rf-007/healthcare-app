package com.example.healthcareapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class CardioDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "doctorcardio.db";
    private static final String TABLE_NAME = "cardio";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ROWID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SPECIALIST = "specialist";
    private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
            " ("+ KEY_ROWID+" integer primary key autoincrement, "+ KEY_NAME + " text, "+ KEY_SPECIALIST+ " text)";
    private Context context;

    private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;


    public CardioDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Toast.makeText(context, "Database Created!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase appointDB) {
        try {
            appointDB.execSQL(CREATE_TABLE);
            Toast.makeText(context, "Table generated!", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase appointDB, int i, int i1) {
        try{
            Toast.makeText(context, "Dropped Table", Toast.LENGTH_SHORT).show();
            appointDB.execSQL(DROP_TABLE);
        } catch (SQLException e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
}
