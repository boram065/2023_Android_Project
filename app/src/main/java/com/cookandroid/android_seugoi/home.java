package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class home extends AppCompatActivity {
    private ArrayList<home_items> studyList;
    private home_listview_Adapter adapter;
    ListView listView;
    EditText edtSearch;
    ImageView imgSearch;
    TextView yourName;

    ClassDataSource dataSource;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        edtSearch = findViewById(R.id.edtSearch);
        imgSearch = findViewById(R.id.imgSearch);
        yourName = findViewById(R.id.yourName);
        listView = findViewById(R.id.listMystudy);

        studyList = new ArrayList<>();
        adapter = new home_listview_Adapter(studyList, this);
        listView.setAdapter(adapter);

        dataSource = new ClassDataSource(this);
        dataSource.open();

        loadStudyList(); // 리스트를 로드하는 함수를 호출

        Cursor cursor = dataSource.getAllClass();
        if(cursor != null) {
            while(cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_NAME));
                String hashTag = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_HASHTAG));
                String day = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_DAY));

                home_items homeItems = new home_items(title, hashTag, day);
                studyList.add(homeItems);
            }
            cursor.close();
        }
        adapter.notifyDataSetChanged();

        findViewById(R.id.addStudy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), input_study_info.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                home_items selectedItem = studyList.get(position);
                String title = selectedItem.getStudyName();
                String hashtag = selectedItem.getHashTag();
                String day = selectedItem.getDay();

                Intent i = new Intent(getApplicationContext(), study_join_intro.class);
                i.putExtra("studyName", title);
                i.putExtra("hashTag", hashtag);
                i.putExtra("day", day);
                startActivity(i);
            }
        });
    }

    // 리스트를 로드하는 함수
    @SuppressLint("Range")
    private void loadStudyList() {
        Cursor cursor = dataSource.getAllClass();
        if (cursor != null) {
            studyList.clear(); // 기존 리스트를 비움
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_NAME));
                String hashTag = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_HASHTAG));
                String day = cursor.getString(cursor.getColumnIndex(ClassDBHelper.COLUMN_DAY));

                home_items homeItems = new home_items(title, hashTag, day);
                studyList.add(homeItems);
            }
            cursor.close();
            adapter.notifyDataSetChanged(); // 리스트가 업데이트된 것을 알림
        }
    }
}