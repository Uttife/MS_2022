package com.utifeinc.myshelter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LocalDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyShelter_Credentials.db";
    public static final String TABLE_NAME = "Login_Credentials";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "EMAIL";
    public static final String Col_3 = "PASSWORD";

    public LocalDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        //  Toast.makeText(context.getApplicationContext(), "Database Created!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, email);
        contentValues.put(Col_3, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return  false;
        } else {
            return true;
        }

    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return result;
    }

}
