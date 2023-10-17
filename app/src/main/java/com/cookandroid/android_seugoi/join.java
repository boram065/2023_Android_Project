package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class join extends AppCompatActivity {
    EditText id, emailOne, emailTwo, pw, birth, job;
    Button btnlogin;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        id = findViewById(R.id.id);
        emailOne = findViewById(R.id.emailOne);
        emailTwo = findViewById(R.id.emailTwo);
        pw = findViewById(R.id.pw);
        birth = findViewById(R.id.birth);
        job = findViewById(R.id.job);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}
