package com.aditiyagilang.acara23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button btnSend;
    private String KEY_NAME = "NAMA";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById((R.id.input));
        btnSend =(Button) findViewById(R.id.daftar);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nama = name.getText().toString();
                    if (nama != ""){
                        Intent i = new Intent(MainActivity.this, data.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplication(),"YOU NEED FILL YOUR NAME", Toast.LENGTH_SHORT);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplication(),"ERROR, TRY AGAIN!", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}