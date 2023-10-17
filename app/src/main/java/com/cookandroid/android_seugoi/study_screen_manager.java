package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;

public class study_screen_manager extends AppCompatActivity {
    TextView study_NameM, hashtagM;
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

        ListView listView = findViewById(R.id.btnMyStudy);

//        // items 리스트 초기화
//        items = new ArrayList<>();
//        mAdapter = new study_screen_manager_listview_Adapter(items, this);
//        listView.setAdapter(mAdapter);

//        Intent in = getIntent();
//        String taskTitle = in.getStringExtra("taskTitle");
//        String taskContent = in.getStringExtra("taskContent");
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        String txtDay =  (year + "." + month + "." + day);

//        Intent i = getIntent();
//        String studyName = i.getStringExtra("studyName");
//        study_NameM.setText(studyName);
//        String hashTag = i.getStringExtra("hashTag");
//        hashtagM.setText(hashTag);

        findViewById(R.id.addWork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                // 과제 제목과 내용이 비어있지 않을 때만 리스트에 추가
//                if (!taskTitle.isEmpty() || !taskContent.isEmpty()) {
//                    study_screen_manager_items newItem = new study_screen_manager_items(taskTitle, txtDay);
//                    items.add(newItem);
//                    mAdapter.notifyDataSetChanged();

                    Intent intent = new Intent(getApplicationContext(), study_manager_screen.class);
                    startActivity(intent);
//                }
            }
        });

        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
