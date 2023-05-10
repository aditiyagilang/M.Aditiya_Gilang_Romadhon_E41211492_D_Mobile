package com.example.minggu10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAcara33, btnAcara34, btnAcara34_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAcara33 = findViewById(R.id.btnLaunchMaps);
        btnAcara33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acara33Activity();
            }
        });

        btnAcara34 = findViewById(R.id.btnLaunchMaps2);
        btnAcara34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acara34Activity();
            }
        });

        btnAcara34_2 = findViewById(R.id.btnLaunchMaps3);
        btnAcara34_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acara34_2Activity();
            }
        });
    }

    private void acara33Activity() {
        Intent intent = new Intent(this, Acara33.class);
        startActivity(intent);
    }
    private void acara34Activity() {
        Intent intent = new Intent(this, Acara34.class);
        startActivity(intent);
    }
    private void acara34_2Activity() {
        Intent intent = new Intent(this, Acara34_2.class);
        startActivity(intent);
    }
}