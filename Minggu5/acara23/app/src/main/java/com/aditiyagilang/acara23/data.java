package com.aditiyagilang.acara23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class data extends AppCompatActivity {
    TextView name;
    TextView name2;
    TextView nem;
    TextView mail;
    private String nama;
    private String nama2;
    private String nim;
    private String email;
    private String KEY_NAME = "NAMA";
    private String KEY_NIM = "NIM";
    private String KEY_EMAIL = "EMAIL";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        name = (TextView) findViewById(R.id.name);
        name2 = (TextView) findViewById(R.id.nama2);
        nem = (TextView) findViewById(R.id.nim);
        mail = (TextView) findViewById(R.id.email);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        name.setText("Hello, " + nama + " !");
        nama2 = extras.getString(KEY_NAME);
        name2.setText(nama);
        nim = extras.getString(KEY_NIM);
        nem.setText(nim);
        email = extras.getString(KEY_EMAIL);
        mail.setText(email);
    }
    public void cari(View view){
        Intent intent = new Intent(data.this,search.class);

        startActivity(intent);
    }
}