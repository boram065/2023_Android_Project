package com.cookandroid.android_seugoi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper { //DB테이블 생성

    //유저 테이블
    public static String userID= "userID";
    public static String userPass= "userPass";
    public static String userName= "userName";
    public static String userEmail= "userEmail";

    //스터디 테이블
    public static String studyID= "studyID";
    public static String studyName= "studyName";
    public static String studyDescription= "studyDescription"; // 스터디 설명
    public static String creatorID= "creatorID"; // 스터디 가입한 사용자

    //스터디 참여 테이블
    public static String assignmentID = "assignmentID";
    public static String assignmentTitle = "assignmentTitle";
    public static String assignmentDescription = "assignmentDescription";
    public static String dueDate = "dueDate";


    //creatorID 필요

    //스터디 과제 테이블
    public static String submissionID = "assignmentID";
    public static String userSubID = "userID";
    // 테이블 만들 때는 assignmentID와 dueDate, creatorID 가 필요
    public static String submissionTitle = "submissionTitle";
    public static String submissionContent = "submissionContent";




    public DBHelper(@Nullable Context context) {
        super(context, "seugoiUser.db", null, 1);
    }
    private static String createUserTable = "CREATE TABLE userTable (" +
            userID + " VARCHAR(20) PRIMARY KEY, " +
            userPass + " VARCHAR(20), " +
            userName + " VARCHAR(20), " +
            userEmail + " VARCHAR(30)" +
            ")";

    private static final String createStudyTable = "CREATE TABLE studyTable (" +
            studyID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            studyName + " TEXT, " +
            studyDescription + " TEXT, " +
            creatorID + " INTEGER" +
            ")";

    private static final String createAssignmentTable = "CREATE TABLE  assignmentTable (" +
            assignmentID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            assignmentTitle + " INTEGER, " +
            assignmentTitle + " TEXT, " +
            assignmentDescription + " TEXT, " +
            dueDate + " TEXT, " +
            creatorID + " INTEGER" +
            ")";

    private static final String createSubmissionTable = "CREATE TABLE createSubmissionTable (" +
            submissionID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            userSubID + " INTEGER, " +
            assignmentID + " INTEGER, " +
            dueDate + " TEXT, " +
            creatorID+" TEXT, "+
            submissionTitle + " TEXT, " +
            submissionContent + " TEXT" +
            ")";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //user 테이블 생성
//        String sql="CREATE TABLE userTable(userID VARCHAR(20) PRIMARY KEY, userPass VARCHAR(20), userName VARCHAR(20), userEmail VARCHAR(30))";
//        sqLiteDatabase.execSQL(sql); //sql 실행
        sqLiteDatabase.execSQL(createUserTable);
        sqLiteDatabase.execSQL(createStudyTable);
        sqLiteDatabase.execSQL(createAssignmentTable);
        sqLiteDatabase.execSQL(createSubmissionTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS userTable";
        sqLiteDatabase.execSQL(sql); //sql 명령어 실행 (table삭제)
        onCreate(sqLiteDatabase); //다시 테이블 생성
    }

}