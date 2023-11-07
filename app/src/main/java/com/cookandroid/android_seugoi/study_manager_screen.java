package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class study_manager_screen extends AppCompatActivity {
    EditText task_Title, task_Content;
    Button make_Task;
    TaskDataSource dataSource;

    @SuppressLint({"MissingInflatedId", "Range"})
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

        // 데이터 베이스
        dataSource = new TaskDataSource(this);
        dataSource.open();

        // make_Task 버튼 클릭 시
        make_Task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskTitle = task_Title.getText().toString();
                String taskContent = task_Content.getText().toString();
                // 서울 지금 현재 날짜 가져오기
                Calendar calendar = Calendar.getInstance();
                TimeZone seoulTimeZone = TimeZone.getTimeZone("Asia/Seoul");
                calendar.setTimeZone(seoulTimeZone);
                Date date = calendar.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                String txtDay = sdf.format(date);

                boolean isTaskTitleExists = false;
                if (isTaskTitleExists) {
                    // 이미 같은 제목의 과제가 존재하므로 추가하지 않음
                    Toast.makeText(getApplicationContext(), "같은 제목의 과제가 이미 존재합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    // 같은 제목의 과제가 없으므로 과제를 추가
                    long newRowId = dataSource.createTask(taskTitle, taskContent, txtDay);

                    if (newRowId != -1) {
                        // 과제 추가 성공
                        Toast.makeText(getApplicationContext(), "과제가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        // 과제 추가 실패
                        Toast.makeText(getApplicationContext(), "과제 추가에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                }

                Intent in = new Intent(getApplicationContext(), come.class);
                in.putExtra("taskTitle", taskTitle);
                in.putExtra("taskDay", txtDay);
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