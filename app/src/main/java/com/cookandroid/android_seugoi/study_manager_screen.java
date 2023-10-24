package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class study_manager_screen extends AppCompatActivity {
    EditText task_Title, task_Content;
    Button make_Task;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_manager_screen);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        task_Title = findViewById(R.id.task_Title);
        task_Content = findViewById(R.id.task_Content);
        make_Task = findViewById(R.id.make_Task);

        String result = "리스트 추가";
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String txtDay = dateFormat.format(currentDate);

        // make_Task 버튼 클릭 시
        make_Task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskTitle = task_Title.getText().toString();
                String taskContent = task_Content.getText().toString();

                Intent in = new Intent(getApplicationContext(), come.class);
                in.putExtra("taskTitle", taskTitle); // taskTitle 넘겨주기
                in.putExtra("txtDay", txtDay);
                in.putExtra("taskContent", taskContent);
                in.putExtra("result", result); // 버튼 클릭 시의 결과 넘겨주기
                startActivity(in);
            }
        });

        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), home.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnBefore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}