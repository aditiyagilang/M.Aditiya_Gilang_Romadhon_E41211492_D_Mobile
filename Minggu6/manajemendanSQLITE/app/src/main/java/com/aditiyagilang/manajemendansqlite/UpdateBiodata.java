package com.aditiyagilang.manajemendansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1, btn2;
    EditText text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
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
        bt1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        bt1.setOnClickListener(view -> {
            SQLiteDatabase db1 = dbHelper.getWritableDatabase();
            db1.execSQL("update biodata set nama = '"+
                    text1.getText().toString() + "', tgl='"+
                    text2.getText().toString() + "', jk='"+
                    text3.getText().toString() + "', alamat='"+
                    text4.getText().toString() + "', where no='"+
                    text5.getText().toString() +
                    "'");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
            acara28.ma.RefreshList();
            finish();
        });
        btn2.setOnClickListener(view -> {
            finish();
        });
    }
}