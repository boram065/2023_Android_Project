package com.cookandroid.android_seugoi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper { //DB테이블 생성
    public static final String USER_TABLE = "userTable"; // 로그인 테이블
    public static final String STUDY_TABLE = "studyTable"; // 스터디 테이블
    public static final String ASSIGNMENT_TABLE = "assignmentTable";
    public static final String SUBMISSION_TABLE = "submissionTable";

    public static final String USER_ID = "userID";
    public static final String USER_PASS = "userPass";
    public static final String USER_NAME = "userName";
    public static final String USER_EMAIL = "userEmail";

    public static final String STUDY_ID = "studyID";
    public static final String STUDY_NAME = "studyName";
    public static final String STUDY_DESCRIPTION = "studyDescription";
    public static final String STUDY_CREATOR_ID = "creatorID";

    public static final String ASSIGNMENT_ID = "assignmentID";
    public static final String ASSIGNMENT_TITLE = "assignmentTitle";
    public static final String ASSIGNMENT_DESCRIPTION = "assignmentDescription";
    public static final String ASSIGNMENT_DUE_DATE = "dueDate";
    public static final String ASSIGNMENT_CREATOR_ID = "creatorID";

    public static final String SUBMISSION_ID = "submissionID";
    public static final String SUBMISSION_USER_ID = "userID";
    public static final String SUBMISSION_ASSIGNMENT_ID = "assignmentID";
    public static final String SUBMISSION_DATE = "submissionDate";
    public static final String SUBMISSION_CONTENT = "submissionContent";

    public DBHelper(@Nullable Context context) {
        super(context, "seugoiUser.db", null, 1);
    }
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + " (" +
            USER_ID + " VARCHAR(20) PRIMARY KEY, " +
            USER_PASS + " VARCHAR(20), " +
            USER_NAME + " VARCHAR(20), " +
            USER_EMAIL + " VARCHAR(30)" +
            ")";

    private static final String CREATE_STUDY_TABLE = "CREATE TABLE " + STUDY_TABLE + " (" +
            STUDY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            STUDY_NAME + " TEXT, " +
            STUDY_DESCRIPTION + " TEXT, " +
            STUDY_CREATOR_ID + " INTEGER" +
            ")";

    private static final String CREATE_ASSIGNMENT_TABLE = "CREATE TABLE " + ASSIGNMENT_TABLE + " (" +
            ASSIGNMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            STUDY_ID + " INTEGER, " +
            ASSIGNMENT_TITLE + " TEXT, " +
            ASSIGNMENT_DESCRIPTION + " TEXT, " +
            ASSIGNMENT_DUE_DATE + " TEXT, " +
            ASSIGNMENT_CREATOR_ID + " INTEGER" +
            ")";

    private static final String CREATE_SUBMISSION_TABLE = "CREATE TABLE " + SUBMISSION_TABLE + " (" +
            SUBMISSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SUBMISSION_USER_ID + " INTEGER, " +
            SUBMISSION_ASSIGNMENT_ID + " INTEGER, " +
            SUBMISSION_DATE + " TEXT, " +
            SUBMISSION_CONTENT + " TEXT" +
            ")";

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
