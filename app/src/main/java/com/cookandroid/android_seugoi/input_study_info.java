package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class input_study_info extends AppCompatActivity {
    EditText study_Name, hashtag, end_Day, study_Title, study_Explain, work1, work2, work3, studyWork, recom1, recom2, recom3;
    Button btn_Next;
    ClassDataSource dataSource;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_study_info);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // EditText
        study_Name = findViewById(R.id.study_Name);
        hashtag = findViewById(R.id.hashtag);
        end_Day = findViewById(R.id.end_Day);
        study_Title = findViewById(R.id.study_Title);
        study_Explain = findViewById(R.id.study_Explain);
        work1 = findViewById(R.id.work1);
        work2 = findViewById(R.id.work2);
        work3 = findViewById(R.id.work3);
        studyWork = findViewById(R.id.studyWork);
        recom1 = findViewById(R.id.recom1);
        recom2 = findViewById(R.id.recom2);
        recom3 = findViewById(R.id.recom3);

        // Button
        btn_Next = findViewById(R.id.btn_Next);

        // 데이터 베이스
        dataSource = new ClassDataSource(this);
        dataSource.open();

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = study_Name.getText().toString();
                String hashTag = hashtag.getText().toString();
                String title = study_Title.getText().toString();
                String explain = study_Explain.getText().toString();
                String Work1 = work1.getText().toString();
                String Work2 = work2.getText().toString();
                String Work3 = work3.getText().toString();
                String studywork = studyWork.getText().toString();
                String Recom1 = recom1.getText().toString();
                String Recom2 = recom2.getText().toString();
                String Recom3 = recom3.getText().toString();
                Calendar calendar = Calendar.getInstance();
                // 서울 지금 현재 날짜 가져오기
                TimeZone seoulTimeZone = TimeZone.getTimeZone("Asia/Seoul");
                calendar.setTimeZone(seoulTimeZone);
                Date date = calendar.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                String txtDay = sdf.format(date);

                boolean ClassCheck = false;

                if(ClassCheck) {
                    Toast.makeText(getApplicationContext(), "같은 제목의 클래스가 이미 존재합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    long newRowId = dataSource.createClass(name, hashTag, title, explain, Work1, Work2, Work3, studywork, Recom1, Recom2, Recom3, txtDay);

                    if(newRowId != -1) {
                        Toast.makeText(getApplicationContext(), "클래스가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "클래스 추가에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                }

                Intent intent = new Intent(getApplicationContext(), study_join_intro.class);
                intent.putExtra("name", name);
                intent.putExtra("hashTag", hashTag);
                intent.putExtra("day", txtDay);
                startActivity(intent);
            }
        });

        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), home.class);
                startActivity(in);
            }
        });

        findViewById(R.id.btnBefore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), home.class);
                startActivity(in);
            }
        });
    }
}