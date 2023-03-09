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
    EditText nem;
    EditText mail;
    EditText nama2;
    Button btnSend;
    private String KEY_NAME = "NAMA";
    private String KEY_NIM = "NIM";
    private String KEY_EMAIL = "EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById((R.id.input));
        nama2 = (EditText) findViewById((R.id.input));
        nem = (EditText) findViewById((R.id.nim));
        mail = (EditText) findViewById((R.id.email));
        btnSend =(Button) findViewById(R.id.daftar);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nama = name.getText().toString();
                    String nama22 = nama2.getText().toString();
                    String nim = nem.getText().toString();
                    String email = mail.getText().toString();
                    if (nama != ""){
                        Intent i = new Intent(MainActivity.this, data.class);
                        i.putExtra(KEY_NAME , nama);
                        i.putExtra(KEY_NAME , nama22);
                        i.putExtra(KEY_NIM, nim);
                        i.putExtra(KEY_EMAIL, email);
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