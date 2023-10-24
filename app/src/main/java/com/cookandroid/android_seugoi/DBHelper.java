package com.cookandroid.android_seugoi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper { //DB테이블 생성
    public DBHelper(@Nullable Context context) {
        super(context, "seugoiUser.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //user 테이블 생성
        String sql="CREATE TABLE userTable(userID VARCHAR(20) PRIMARY KEY, userPass VARCHAR(20), userName VARCHAR(20), userEmail VARCHAR(30))";
        sqLiteDatabase.execSQL(sql); //sql 실행
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS userTable";
        sqLiteDatabase.execSQL(sql); //sql 명령어 실행 (table삭제)
        onCreate(sqLiteDatabase); //다시 테이블 생성
    }

}
