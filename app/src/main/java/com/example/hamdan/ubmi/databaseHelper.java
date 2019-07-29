package com.example.hamdan.ubmi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Virus on 3/23/2018.
 */

public class databaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "databaseHelper";
    public static final String TABLE_NAME = "BMI_data";
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "BMI";



    public databaseHelper(Context context)
    {
        super(context,TABLE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE " +TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_2+" TEXT)";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //I used ctrl+O for called overrided methods..
        db.execSQL(" DROP IF TABLE EXISTS "+ TABLE_NAME );
        onCreate(db);

    }

    public boolean addData(String item)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_2,item);


        Log.d(TAG,"Adding Data "+item+" to "+TABLE_NAME);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result== -1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " SELECT *FROM "+TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }



}
