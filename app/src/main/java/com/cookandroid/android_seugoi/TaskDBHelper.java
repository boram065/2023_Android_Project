package com.cookandroid.android_seugoi;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TaskDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TaskDB.db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_DAY = "day";

    private static final String DATABASE_CREATE = "create table " + TABLE_TASKS + "(" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_TITLE + " text not null, " +
            COLUMN_CONTENT + " text not null, " +
            COLUMN_DAY + " text not null);";

    public TaskDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }
}
