package com.aditiyagilang.manajemendansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {
protected Cursor cursor;
DataHelper dbHelper;
Button bt1, btn2;
EditText text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        bt1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        bt1.setOnClickListener((view -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("insert into biodata( no, nama, tgl, jk, alamat) values('"+
                    text1.getText().toString() + "','" +
                    text2.getText().toString() + "','" +
                    text3.getText().toString() + "','" +
                    text4.getText().toString() + "','" +
                    text5.getText().toString() + "','" +
                    "') ");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
            acara28.ma.RefreshList();
            finish();
        }));
        btn2.setOnClickListener(view -> {
            finish();
        });
    }
}