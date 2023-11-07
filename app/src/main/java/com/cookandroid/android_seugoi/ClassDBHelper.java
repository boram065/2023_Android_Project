package com.cookandroid.android_seugoi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClassDBHelper extends SQLiteOpenHelper {
    private static final String CLASS_DATABASE_NAME = "ClassDB.db";
    private static final int CLASS_DATABASE_VERSION = 2;
    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_HASHTAG = "hashTag";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_EXPLAIN = "explanation";
    public static final String COLUMN_WORK1 = "work1";
    public static final String COLUMN_WORK2 = "work2";
    public static final String COLUMN_WORK3 = "work3";
    public static final String COLUMN_STUDYWORK = "studyWork";
    public static final String COLUMN_RECOM1 = "recom1";
    public static final String COLUMN_RECOM2 = "recom2";
    public static final String COLUMN_RECOM3 = "recom3";
    public static final String COLUMN_DAY = "day";

    private static final String DATABASE_CREATE = "create table " + TABLE_TASKS + "(" +
            COLUMN_ID + " integer primary key autoincrement not null, "+
            COLUMN_NAME + " text not null, " +
            COLUMN_HASHTAG + " text not null, " +
            COLUMN_TITLE + " text not null, " +
            COLUMN_EXPLAIN + " text not null, " +
            COLUMN_WORK1 + " text not null, " +
            COLUMN_WORK2 + " text not null, " +
            COLUMN_WORK3 + " text not null, " +
            COLUMN_STUDYWORK + " text not null, " +
            COLUMN_RECOM1 + " text not null, " +
            COLUMN_RECOM2 + " text not null, " +
            COLUMN_RECOM3 + " text not null, " +
            COLUMN_DAY + " text not null);";

    public ClassDBHelper(Context context) {
        super(context, CLASS_DATABASE_NAME, null, CLASS_DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }
}