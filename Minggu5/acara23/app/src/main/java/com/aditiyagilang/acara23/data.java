package com.aditiyagilang.acara23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class data extends AppCompatActivity {
    TextView name;
    private String nama;
    private String KEY_NAME = "NAMA";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        name = (TextView) findViewById(R.id.name);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        name.setText("Hello, " + nama + " !");
    }
}