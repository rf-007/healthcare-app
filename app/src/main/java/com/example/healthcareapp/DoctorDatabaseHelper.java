package com.example.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import android.util.Log;
import androidx.annotation.Nullable;


public class DoctorDatabaseHelper extends SQLiteOpenHelper{


        public Context context;
        public static final String DATABASE_NAME = "DoctorDB.db";
        public static final int DATABASE_VERSION = 1;

        public static final String TABLE_NAME = "Doctor";
        public static final String COLUMN_DOCID = "Doc_Id";
        public static final String COLUMN_DOCNAME = "Doc_name";
        public static final String COLUMN_HOSPITALNAME = "Hosp_name";
        public static final String COLUMN_SPECIALIZATION = "Specialization";
        public static final String COLUMN_SCHEDULE = "Schedule";


        DoctorDatabaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_DOCID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_HOSPITALNAME + " TEXT, " +
                    COLUMN_DOCNAME + " TEXT, " +
                    COLUMN_HOSPITALNAME + " TEXT," +
                    COLUMN_SPECIALIZATION + " TEXT,"+
                    COLUMN_SCHEDULE + " TEXT);";
            db.execSQL(query);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        void addDoctor(String doctorname, String hospitalname, String specialization, String schedule){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(COLUMN_DOCNAME, doctorname);
            cv.put(COLUMN_HOSPITALNAME, hospitalname);
            cv.put(COLUMN_SPECIALIZATION, specialization);
            cv.put(COLUMN_SCHEDULE, schedule);
            long result = db.insert(TABLE_NAME,null, cv);
            if(result == -1){
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
            }
        }

        Cursor readAllHospitalData(){
            String query = "SELECT * FROM " + TABLE_NAME;
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = null;
            if(db != null){
                cursor = db.rawQuery(query, null);
            }
            return cursor;
        }

        void updateData(String doctorname, String hospitalname, String specialization, String schedule){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_DOCNAME, doctorname);
            cv.put(COLUMN_HOSPITALNAME, hospitalname);
            cv.put(COLUMN_SPECIALIZATION, specialization);
            cv.put(COLUMN_SCHEDULE, schedule);

            long result = db.update(TABLE_NAME, cv, "Doc_Id=?", new String[]{doctorname});
            if(result == -1){
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
            }

        }

        void deleteOneRow(String row_id){
            SQLiteDatabase db = this.getWritableDatabase();
            long result = db.delete(TABLE_NAME, "DocId=?", new String[]{row_id});
            if(result == -1){
                Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
            }
        }

        void deleteAllData(){
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_NAME);
        }

    }



