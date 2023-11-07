package com.cookandroid.android_seugoi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class join extends AppCompatActivity {
    EditText id, emailOne, emailTwo, pw, birth, job;
    Button btnlogin;

    DBHelper myHelper;
    SQLiteDatabase sqlDB;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        // 타이틀 바 없애기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        id = findViewById(R.id.id);
        emailOne = findViewById(R.id.emailOne);
        emailTwo = findViewById(R.id.emailTwo);
        pw = findViewById(R.id.pw);
        birth = findViewById(R.id.birth);
        job = findViewById(R.id.job);
        btnlogin = findViewById(R.id.btnlogin);

        myHelper = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = emailOne.getText().toString() +"@"+ emailTwo.getText().toString();
                String userID = id.getText().toString();
                String userPass = pw.getText().toString();
                String userName = job.getText().toString();
//                int userBirth = (birth.getText().toString().trim());
//                String userEmail ="rlakgdls@email.com";
//                String userID = "aaa";
//                String userPass = "aaaa0315";
//                String userName = "김하은";


                try { //DB 연결
                    if(!userID.isEmpty() && !userPass.isEmpty()){
                        //DB연결, 회원가입 sql insert 명령어 처리
                        sqlDB = myHelper.getWritableDatabase();
//                        "INSERT INTO userTable  VALUES ('a','b','c','d');"
//                        sqlDB.execSQL("INSERT INTO userTable(userID, userPass, userName, userEmail) " +
//                                "VALUES ( '"+ userID + "', "+ "'" + userPass + "', " + "'"+ userName + "', "+userEmail + ");");
//                        sqlDB.execSQL("INSERT INTO userTable  VALUES ('a','b','c','d');");
                        String sqlQuery = "INSERT INTO userTable (userID, userPass, userName, userEmail) VALUES ('" + userID + "', '" + userPass + "', '" + userName + "', '" + userEmail + "');";
                        sqlDB.execSQL(sqlQuery);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "회원가입성공",Toast.LENGTH_SHORT).show();

                        //로그인 화면으로 넘어가기
                        Intent intent = new Intent(getApplicationContext(), login.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "ID와 PW는 필수 입력입니다.",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력실패(ID 중복 또는 DB접속오류)",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}