package com.example.healthcareapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class HospitalDatabaseHelper extends SQLiteOpenHelper{



        public Context context;
        public static final String DATABASE_NAME = "HospitalDB.db";
        public static final int DATABASE_VERSION = 1;

        public static final String TABLE_NAME = "Hospital";
        public static final String COLUMN_HOSPITALID = "Hosp_Id";
        public static final String COLUMN_HOSPITALNAME = "Hosp_name";
        public static final String COLUMN_lOCATION = "location";
        public static final String COLUMN_PHONE = "Phone";


    HospitalDatabaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_HOSPITALID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_HOSPITALNAME + " TEXT, " +
                    COLUMN_lOCATION + " TEXT, " +
                    COLUMN_PHONE + " INTEGER);";
            db.execSQL(query);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        void addHospital(String hospitalname, String location, int phone){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(COLUMN_HOSPITALNAME, hospitalname);
            cv.put(COLUMN_lOCATION, location);
            cv.put(COLUMN_PHONE, phone);
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

        void updateData(String hospitalname, String location, String phone){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_HOSPITALNAME, hospitalname);
            cv.put(COLUMN_lOCATION, location);
            cv.put(COLUMN_PHONE, phone);

            long result = db.update(TABLE_NAME, cv, "Hosp_name=?", new String[]{phone});
            if(result == -1){
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
            }

        }

        void deleteOneRow(String hospitalname){
            SQLiteDatabase db = this.getWritableDatabase();
            long result = db.delete(TABLE_NAME, "Hosp_name=?", new String[]{hospitalname});
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

