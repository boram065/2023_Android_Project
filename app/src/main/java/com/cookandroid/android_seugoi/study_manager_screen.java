package com.cookandroid.android_seugoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class study_manager_screen extends AppCompatActivity {
    EditText task_Title, task_Content;
    Button make_Task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_manager_screen);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        task_Title = findViewById(R.id.task_Title);
        task_Content = findViewById(R.id.task_Content);
        make_Task = findViewById(R.id.make_Task);

//        // 입력한 과제 정보 가져오기
//        String taskTitle = task_Title.getText().toString();
//        String taskContent = task_Content.getText().toString();

        // make_Task 버튼 클릭 시
        make_Task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // study_screen_manager로 데이터 전달
                Intent intent = new Intent(getApplicationContext(), study_screen_manager.class);
//                intent.putExtra("taskTitle", taskTitle);
                startActivity(intent);
            }
        });

//        Intent in = new Intent(getApplicationContext(), come.class);
//        in.putExtra("taskTitle", taskTitle);
//        in.putExtra("taskContent", taskContent);

        findViewById(R.id.btnBefore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), study_join_intro.class);
                startActivity(i);
            }
        });
    }
}
