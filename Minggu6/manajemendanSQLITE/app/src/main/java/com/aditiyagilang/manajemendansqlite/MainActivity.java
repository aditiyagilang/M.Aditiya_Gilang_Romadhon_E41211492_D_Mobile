package com.aditiyagilang.manajemendansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void button1(){
        Intent intent = new Intent(MainActivity.this, acara26.class);
        startActivity(intent);
    }
    public  void  button2(){
        Intent intent1= new Intent(MainActivity.this, acara28.class);
        startActivity(intent1);
    }

}