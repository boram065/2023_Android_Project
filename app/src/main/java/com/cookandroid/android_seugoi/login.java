package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText id, pw;
    TextView txtjoin;
    Button btnlogin;

    DBHelper myHelper;
    SQLiteDatabase sqlDB;


    //    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        id = findViewById(R.id.id);
        pw = findViewById(R.id.pw);
        txtjoin = findViewById(R.id.txtjoin);
        btnlogin = findViewById(R.id.btnlogin);

        myHelper = new DBHelper(this);

        txtjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), join.class);
                startActivity(intent);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), home.class);
                startActivity(in);
            }
        });

//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String userId = id.getText().toString();
//                String userPw = pw.getText().toString();
//                sqlDB = myHelper.getReadableDatabase();
//                Cursor cursor;
//                cursor = sqlDB.rawQuery("SELECT userID, userPass FROM user where userID='"+userId+"' and userPass='"+userPw+"';", null);
//
//                if(cursor.moveToFirst()){ //레코드가 있으면
////                    if (userId.equals("test")){ //관리자인경우
////                        Intent intent = new Intent(login.this, .class);
////                        intent.putExtra("userID", userId);
////                        startActivity(intent);
////                    }
////                    else{
//                    Intent intent = new Intent(getApplicationContext(), home.class);
//                    intent.putExtra("userID", userId);
//                    intent.putExtra("userPass", userPw);
//                    startActivity(intent);
////                    }
//                    id.setText("");
//                    pw.setText("");
//                }
//                else Toast.makeText(getApplicationContext(), "로그인 실패(id/pw 확인바람)", Toast.LENGTH_LONG).show();
//                cursor.close();
//                sqlDB.close();//DB와 커서 사용 후 되도록 close()
//            }
//        });
    }
}