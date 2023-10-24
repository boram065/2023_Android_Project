package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // 화면이 띄워진 후 일정 시간(2초)이 지나면 MainActivity로 이동
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // MainActivity로 이동하는 Intent 생성
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish(); // 현재 화면을 종료
            }
        }, 2000);
    }
}
