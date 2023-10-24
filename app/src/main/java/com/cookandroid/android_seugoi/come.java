package com.cookandroid.android_seugoi;

import android.content.Intent;
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
        String result = intent.getStringExtra("result");
        if(result.equals("리스트 추가")) {
            String title = intent.getStringExtra("taskTitle");
            studyTitle.setText(title);
            String txtDay = intent.getStringExtra("txtDay");
            studyDay.setText(txtDay);
            String context = intent.getStringExtra("taskContent");
            studyContext.setText(context);

        }


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
                intent1.putExtra("title", studyTitle.getText().toString());
                intent1.putExtra("day", studyDay.getText().toString());
                intent1.putExtra("answer", true);
                startActivity(intent1);
            }
        });

    }
}