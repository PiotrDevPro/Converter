package com.piotrdevelop.unityconverter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class FavoriteDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "favoritelist.db";
    public static final int DATABASE_VERSION = 1;

    public FavoriteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_FAVORELIST_TABLE;
        SQL_CREATE_FAVORELIST_TABLE = "CREATE TABLE " +
                Contract.FavoriteEntry.TABLE_NAME + " (" +
                Contract.FavoriteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.FavoriteEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                Contract.FavoriteEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                Contract.FavoriteEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_FAVORELIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.FavoriteEntry.TABLE_NAME);
        onCreate(db);
    }
}