package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class study_join_intro extends AppCompatActivity {
    TextView study_Name, hashtag, study_Title, study_Explain, work1, work2, work3, studyWork, recom1, recom2, recom3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_join_intro);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // TextView
        study_Name = findViewById(R.id.study_Name);
        hashtag = findViewById(R.id.hashtag);
        study_Title = findViewById(R.id.study_Title);
        study_Explain = findViewById(R.id.study_Explain);
        work1 = findViewById(R.id.work1);
        work2 = findViewById(R.id.work2);
        work3 = findViewById(R.id.work3);
        studyWork = findViewById(R.id.studyWork);
        recom1 = findViewById(R.id.recom1);
        recom2 = findViewById(R.id.recom2);
        recom3 = findViewById(R.id.recom3);

//        // input_study_info
//        study_Name.setText("");
//        hashtag.setText("");
//        study_Title.setText("");
//        study_Explain.setText("");
//        work1.setText("");
//        work2.setText("");
//        work3.setText("");
//        studyWork.setText("");
//        recom1.setText("");
//        recom2.setText("");
//        recom3.setText("");

//        Intent intent = getIntent();

//        // input_study_info
//        study_Name.append(intent.getStringExtra("studyName"));
//        hashtag.append(intent.getStringExtra("studyTag"));
//        study_Title.append(intent.getStringExtra("studyTitle"));
//        study_Explain.append(intent.getStringExtra("studyExplain"));
//        work1.append(intent.getStringExtra("studyWork1"));
//        work2.append(intent.getStringExtra("studyWork2"));
//        work3.append(intent.getStringExtra("studyWork3"));
//        studyWork.append(intent.getStringExtra("work"));
//        recom1.append(intent.getStringExtra("re1"));
//        recom2.append(intent.getStringExtra("re2"));
//        recom3.append(intent.getStringExtra("re3"));

        findViewById(R.id.btnBefore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.btnWork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), study_screen_manager.class);
                startActivity(i);
            }
        });
    }
}