package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class come extends AppCompatActivity {
    TextView studyTitle, studyDay, studyContext;
    EditText chat;
    Button btnUpload;

    TaskDataSource dataSource;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.come);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        studyTitle = findViewById(R.id.studyTitle);
        studyDay = findViewById(R.id.studyDay);
        studyContext = findViewById(R.id.studyContext);
        chat = findViewById(R.id.chat);
        btnUpload = findViewById(R.id.btnUpload);

        Intent intent = getIntent();
        String title = intent.getStringExtra("taskTitle");
        String day = intent.getStringExtra("taskDay");

        dataSource = new TaskDataSource(this);
        dataSource.open();

        // 데이터베이스에서 정보 가져오기
        Cursor cursor = dataSource.getTaskByTitleAndDay(title, day);

        if (cursor != null && cursor.moveToFirst()) {
            String taskTitle = cursor.getString(cursor.getColumnIndex(TaskDBHelper.COLUMN_TITLE));
            String taskContent = cursor.getString(cursor.getColumnIndex(TaskDBHelper.COLUMN_CONTENT));
            String taskDay = cursor.getString(cursor.getColumnIndex(TaskDBHelper.COLUMN_DAY));

            // 정보를 TextView 등에 표시
            studyTitle.setText(taskTitle);
            studyContext.setText(taskContent);
            studyDay.setText(taskDay);
            cursor.close();
        }
        dataSource.close();

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
                Intent intent1 = new Intent(getApplicationContext(), study_screen_manager.class);
                startActivity(intent1);
            }
        });

    }
}