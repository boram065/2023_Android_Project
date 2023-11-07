package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class study_join_intro extends AppCompatActivity {
    TextView study_Name, hashtag, study_Title, study_Explain, work1, work2, work3, studyWork, recom1, recom2, recom3;
    Button btnBefore, btnWork;
    ImageView logo;
    ClassDataSource dataSource;

    @SuppressLint({"MissingInflatedId", "Range", "WrongViewCast"})
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

        // button
        btnBefore =  findViewById(R.id.btnBefore);
        btnWork = findViewById(R.id.btnWork);
        logo = findViewById(R.id.logo);

        Intent intent = getIntent();
        String studyName = intent.getStringExtra("studyName");
        String studyHashTag = intent.getStringExtra("hashTag");
        String studyDay = intent.getStringExtra("day");
        System.out.println("studyName"+ studyName);

        dataSource = new ClassDataSource(this);
        dataSource.open();

        Cursor cursor = dataSource.getClassByTitleAndHashtagAndDay(studyName, studyHashTag, studyDay);

        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_NAME));
            String hashTag = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_HASHTAG));
            String title = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_TITLE));
            String explain = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_EXPLAIN));
            String Work1 = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_WORK1));
            String Work2 = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_WORK2));
            String Work3 = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_WORK3));
            String studywork = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_STUDYWORK));
            String Recom1 = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_RECOM1));
            String Recom2 = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_RECOM2));
            String Recom3 = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_RECOM3));

            study_Name.setText(name);
            hashtag.setText(hashTag);
            study_Title.setText(title);
            study_Explain.setText(explain);
            work1.setText(Work1);
            work2.setText(Work2);
            work3.setText(Work3);
            studyWork.setText(studywork);
            recom1.setText(Recom1);
            recom2.setText(Recom2);
            recom3.setText(Recom3);

            cursor.close();
        }
        dataSource.close();

        btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), home.class);
                startActivity(i);
            }
        });

        btnWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), study_screen_manager.class);
                startActivity(i);
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), home.class);
                startActivity(in);
            }
        });
    }
}