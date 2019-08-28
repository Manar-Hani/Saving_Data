package com.example.localdb.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "users_table";
    private static final String COL1 = "id";
    private static final String COL2 = "name";
    private static final String COL3 = "age";
    private static final String COL4 = "job";
    private static final String COL5 = "gender";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE " + TABLE_NAME + "("
                + COL1 + " INTEGER PRIMARY KEY  AUTOINCREMENT, "
                + COL2 + " TEXT,"
                + COL3 + " TEXT,"
                + COL4 + " TEXT,"
                + COL5 + " TEXT"
                +")";
        db.execSQL(createUsersTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP  TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL1,0);
        contentValues.put(COL2, item);
        contentValues.put(COL3, item);
        contentValues.put(COL4, item);
        contentValues.put(COL5, item);


        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        db.close();

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


}