package com.aditiyagilang.manajemendansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {
protected Cursor cursor;
DataHelper dbHelper;
Button btn;
TextView text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);
        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+ getIntent().getStringExtra("nama") +"'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(0).toString());
            text3.setText(cursor.getString(0).toString());
            text4.setText(cursor.getString(0).toString());
            text5.setText(cursor.getString(0).toString());
        }
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(view -> {
            finish();
        });
    }
}