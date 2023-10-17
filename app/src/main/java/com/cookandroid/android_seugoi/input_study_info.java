package com.cookandroid.android_seugoi;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class input_study_info extends AppCompatActivity {
    EditText study_Name, hashtag, end_Day, study_Title, study_Explain, work1, work2, work3, studyWork, recom1, recom2, recom3;
    Button btn_Next;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_study_info);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(input_study_info.this, study_join_intro.class);
//                intent.putExtra("studyName", study_Name.getText().toString());
//                intent.putExtra("studyTag", hashtag.getText().toString());
//                intent.putExtra("studyTitle", study_Title.getText().toString());
//                intent.putExtra("studyExplain", study_Explain.getText().toString());
//                intent.putExtra("studyWork1", work1.getText().toString());
//                intent.putExtra("studyWork2", work2.getText().toString());
//                intent.putExtra("studyWork3", work3.getText().toString());
//                intent.putExtra("work", studyWork.getText().toString());
//                intent.putExtra("re1", recom1.getText().toString());
//                intent.putExtra("re2", recom2.getText().toString());
//                intent.putExtra("re3", recom3.getText().toString());

//                Intent i = new Intent(input_study_info.this, home.class);
//                i.putExtra("studyName", study_Name.getText().toString());

                // btn_Next를 누르면 study_join_intro로 넘어가기
                startActivity(intent);
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
