package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class study_screen_manager extends AppCompatActivity {
    ListView listView;
    private ArrayList<study_screen_manager_items> items;
    private study_screen_manager_listview_Adapter mAdapter;
    TaskDataSource dataSource;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_screen_manager);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        listView = findViewById(R.id.listStudy);

        // items 리스트 초기화
        items = new ArrayList<>();
        mAdapter = new study_screen_manager_listview_Adapter(items, this);
        listView.setAdapter(mAdapter);

        // 데이터베이스 관련 초기화
        dataSource = new TaskDataSource(this);
        dataSource.open();

        // 데이터베이스에서 taskTitle과 day를 불러와 리스트에 추가
        Cursor cursor = dataSource.getAllTasks();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String taskTitle = cursor.getString(cursor.getColumnIndex(TaskDBHelper.COLUMN_TITLE));
                String day = cursor.getString(cursor.getColumnIndex(TaskDBHelper.COLUMN_DAY));

                // 가져온 데이터로 리스트 아이템 생성
                study_screen_manager_items listItem = new study_screen_manager_items(taskTitle, day);
                items.add(listItem);
            }
            cursor.close();
        }
        mAdapter.notifyDataSetChanged();

        findViewById(R.id.addWork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), study_manager_screen.class);
                startActivity(in);
            }
        });

        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 홈 화면으로 이동
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

        // 리스트 아이템 클릭 시 상세 정보 화면으로 이동
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                study_screen_manager_items selectedItem = items.get(position);
                String taskTitle = selectedItem.getTxtStudyTitle();
                String taskDay = selectedItem.getTxtDay();

                Intent intent = new Intent(getApplicationContext(), come.class);
                intent.putExtra("taskTitle", taskTitle);
                intent.putExtra("taskDay", taskDay);
                startActivity(intent);
            }
        });
    }
}