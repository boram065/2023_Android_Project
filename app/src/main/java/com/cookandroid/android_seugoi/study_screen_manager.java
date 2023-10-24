package com.cookandroid.android_seugoi;

import android.content.Intent;
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
        if (items == null) {
            items = new ArrayList<>();
        }
        mAdapter = new study_screen_manager_listview_Adapter(items, this);
        listView.setAdapter(mAdapter);

        Intent intent = getIntent();
        String taskTitle = intent.getStringExtra("title");
        String txtDay = intent.getStringExtra("day");
        boolean answer = intent.getBooleanExtra("answer", false);

        // 과제 생성 버튼 클릭시 리스트 추가
        if (answer) {
            // 가져온 데이터를 바탕으로 리스트 추가
            study_screen_manager_items newItem = new study_screen_manager_items(taskTitle, txtDay);
            items.add(newItem);
            mAdapter.notifyDataSetChanged();
        }

        // 버튼 클릭 하면 list 삭제
//        if (Integer.parseInt(taskTitle) > -1) {
//            item.remove(Integer.parseInt(taskTitle));
//            mAdapter.notifyDataSetChanged();
//        }

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
                finish();
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