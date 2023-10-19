package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class study_screen_manager extends AppCompatActivity {
    TextView study_NameM, hashtagM;
    ListView listView;
    private ArrayList<study_screen_manager_items> items;
    private study_screen_manager_listview_Adapter mAdapter;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_screen_manager);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        listView = findViewById(R.id.listStudy);

        // items 리스트 초기화
        items = new ArrayList<>();
        mAdapter = new study_screen_manager_listview_Adapter(items, this);
        listView.setAdapter(mAdapter);

        Intent in = getIntent();
        String taskTitle = in.getStringExtra("taskTitle");

        findViewById(R.id.addWork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 현재 날짜 구하기 (예: 2023.10.01)
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
                String txtDay = dateFormat.format(new Date());

                // 과제 제목과 내용이 비어있지 않을 때만 리스트에 추가
                if (!taskTitle.isEmpty()) {
                    study_screen_manager_items newItem = new study_screen_manager_items(taskTitle, txtDay);
                    items.add(newItem);
                    mAdapter.notifyDataSetChanged();

                    Intent intent = new Intent(getApplicationContext(), study_manager_screen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "제목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
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
                Intent i = new Intent(getApplicationContext(), home.class);
                startActivity(i);
            }
        });

//        listView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in = new Intent(getApplicationContext(), come.class);
//                startActivity(in);
//            }
//        });
    }
}
