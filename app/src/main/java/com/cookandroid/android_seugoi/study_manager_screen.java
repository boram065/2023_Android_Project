package com.cookandroid.android_seugoi;

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

public class study_manager_screen extends AppCompatActivity {
    EditText task_Title, task_Content;
    Button make_Task;
    ArrayList<String> midList;
    ArrayAdapter<String> adapter;
    ListView listStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_manager_screen);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        listStudy = findViewById(R.id.listStudy);
        task_Title = findViewById(R.id.task_Title);
        task_Content = findViewById(R.id.task_Content);
        make_Task = findViewById(R.id.make_Task);

//        // listview 추가
//        midList = new ArrayList<String>();
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, midList);
//        listStudy.setAdapter(adapter);

        // make_Task 버튼 클릭 시
        make_Task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskTitle = task_Title.getText().toString();
                String taskContent = task_Content.getText().toString();

                Intent intent = new Intent(getApplicationContext(), come.class);
                intent.putExtra("taskTitle", taskTitle);
                intent.putExtra("taskContent", taskContent);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnBefore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), study_join_intro.class);
                startActivity(i);
            }
        });
    }
}
