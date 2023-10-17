package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText id, pw;
    TextView txtjoin;
    Button btnlogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        id = findViewById(R.id.id);
        pw = findViewById(R.id.pw);
        txtjoin = findViewById(R.id.txtjoin);
        btnlogin = findViewById(R.id.btnlogin);

        txtjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), join.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), home.class);
                startActivity(intent);
            }
        });
    }
}
