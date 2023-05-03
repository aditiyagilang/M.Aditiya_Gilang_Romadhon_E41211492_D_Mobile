package com.aditiyagilang.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin, btnRegister;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        btnRegister = findViewById(R.id.back);

        sessionManager = new SessionManager(login.this);

        // Jika pengguna sudah login, maka akan langsung diarahkan ke halaman sukses
        if (sessionManager.isLogin()) {
            Intent intent = new Intent(login.this, succes.class);
            startActivity(intent);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    DataHelper dataHelper = new DataHelper(login.this);
                    if (dataHelper.checkUser(username, password)) {
                        sessionManager.createLoginSession(username, password);

                        Intent intent = new Intent(login.this, succes.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(login.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });
    }

}
