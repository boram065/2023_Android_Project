package com.cookandroid.android_seugoi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ClassDataSource {
    private SQLiteDatabase database;
    private ClassDBHelper dbHelper;

    public ClassDataSource(Context context) {
        dbHelper = new ClassDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createClass(String name, String hashTag, String title, String explain, String work1, String work2, String work3, String studyWork, String recom1, String recom2, String recom3, String day) {
        ContentValues values = new ContentValues();
        values.put(ClassDBHelper.COLUMN_NAME, name);
        values.put(ClassDBHelper.COLUMN_HASHTAG, hashTag);
        values.put(ClassDBHelper.COLUMN_TITLE, title);
        values.put(ClassDBHelper.COLUMN_EXPLAIN, explain);
        values.put(ClassDBHelper.COLUMN_WORK1, work1);
        values.put(ClassDBHelper.COLUMN_WORK2, work2);
        values.put(ClassDBHelper.COLUMN_WORK3, work3);
        values.put(ClassDBHelper.COLUMN_STUDYWORK, studyWork);
        values.put(ClassDBHelper.COLUMN_RECOM1, recom1);
        values.put(ClassDBHelper.COLUMN_RECOM2, recom2);
        values.put(ClassDBHelper.COLUMN_RECOM3, recom3);
        values.put(ClassDBHelper.COLUMN_DAY, day);

        return database.insert(ClassDBHelper.TABLE_TASKS, null, values);
    }

    public Cursor getAllClass() {
        String[] allColumns = { ClassDBHelper.COLUMN_ID, ClassDBHelper.COLUMN_NAME, ClassDBHelper.COLUMN_HASHTAG, ClassDBHelper.COLUMN_TITLE, ClassDBHelper.COLUMN_EXPLAIN, ClassDBHelper.COLUMN_WORK1, ClassDBHelper.COLUMN_WORK2, ClassDBHelper.COLUMN_WORK3, ClassDBHelper.COLUMN_STUDYWORK, ClassDBHelper.COLUMN_RECOM1, ClassDBHelper.COLUMN_RECOM2, ClassDBHelper.COLUMN_RECOM3, ClassDBHelper.COLUMN_DAY };
        return database.query(ClassDBHelper.TABLE_TASKS, allColumns, null, null, null, null, null);
    }

    public Cursor getClassByTitleAndHashtagAndDay(String name, String hashtag, String day) {
        String[] allColumns = { ClassDBHelper.COLUMN_ID, ClassDBHelper.COLUMN_NAME, ClassDBHelper.COLUMN_HASHTAG, ClassDBHelper.COLUMN_TITLE, ClassDBHelper.COLUMN_EXPLAIN, ClassDBHelper.COLUMN_WORK1, ClassDBHelper.COLUMN_WORK2, ClassDBHelper.COLUMN_WORK3, ClassDBHelper.COLUMN_STUDYWORK, ClassDBHelper.COLUMN_RECOM1, ClassDBHelper.COLUMN_RECOM2, ClassDBHelper.COLUMN_RECOM3, ClassDBHelper.COLUMN_DAY };
        String selection = ClassDBHelper.COLUMN_NAME + " = ? AND " + ClassDBHelper.COLUMN_HASHTAG + " = ? AND " + ClassDBHelper.COLUMN_DAY + " = ?";
        String[] selectionArgs = { name, hashtag, day };

        return database.query(ClassDBHelper.TABLE_TASKS, allColumns, selection, selectionArgs, null, null, null);
    }

}
