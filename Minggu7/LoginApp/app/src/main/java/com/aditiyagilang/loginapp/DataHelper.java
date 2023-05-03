package com.aditiyagilang.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




    public class DataHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "login.db";
        private static final int DATABASE_VERSION = 1;

        private static final String TABLE_USER = "user";
        private static final String COLUMN_USER_ID = "user_id";
        private static final String COLUMN_USERNAME = "username";
        private static final String COLUMN_PASSWORD = "password";

        public DataHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                    + COLUMN_USER_ID + " INTEGER PRIMARY KEY," + COLUMN_USERNAME + " TEXT,"
                    + COLUMN_PASSWORD + " TEXT" + ")";
            db.execSQL(CREATE_USER_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            onCreate(db);
        }

        public void addUser(String username, String password) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(COLUMN_USERNAME, username);
            values.put(COLUMN_PASSWORD, password);

            db.insert(TABLE_USER, null, values);
            db.close();
        }

        public boolean checkUser(String username, String password) {
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(TABLE_USER, new String[]{COLUMN_USER_ID},
                    COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?",
                    new String[]{username, password}, null, null, null, null);

            int count = cursor.getCount();

            cursor.close();
            db.close();

            return count > 0;
        }
    }


