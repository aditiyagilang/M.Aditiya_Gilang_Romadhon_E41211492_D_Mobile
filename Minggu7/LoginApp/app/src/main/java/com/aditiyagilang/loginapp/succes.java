package com.aditiyagilang.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class succes extends AppCompatActivity {
Button back;
TextView name;
SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes);
        sessionManager = new SessionManager(succes.this);
        name = findViewById(R.id.textView);

        // Cek apakah user sudah login atau belum
        if (!sessionManager.isLogin()) {
            // Jika belum login, pindahkan ke halaman login
           movetoLogin();
        }
        back = findViewById(R.id.logout);
name.setText("Selamat " + sessionManager.getUserDetail().get(SessionManager.USERNAME) + " Anda Berhasil Login, \n Jika Sudah Coba Logout");
 back.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         sessionManager.logoutSession();
         movetoLogin();

     }
 });


    }
    private void movetoLogin() {
        Intent intent = new Intent(succes.this, login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}