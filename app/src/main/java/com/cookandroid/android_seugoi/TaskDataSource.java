package com.cookandroid.android_seugoi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TaskDataSource {
    private SQLiteDatabase database;
    private TaskDBHelper dbHelper;

    public TaskDataSource(Context context) {
        dbHelper = new TaskDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createTask(String title, String content, String day) {
        ContentValues values = new ContentValues();
        values.put(TaskDBHelper.COLUMN_TITLE, title);
        values.put(TaskDBHelper.COLUMN_CONTENT, content);
        values.put(TaskDBHelper.COLUMN_DAY, day);

        return database.insert(TaskDBHelper.TABLE_TASKS, null, values);
    }

    public Cursor getAllTasks() {
        String[] allColumns = { TaskDBHelper.COLUMN_ID, TaskDBHelper.COLUMN_TITLE, TaskDBHelper.COLUMN_CONTENT, TaskDBHelper.COLUMN_DAY };
        return database.query(TaskDBHelper.TABLE_TASKS, allColumns, null, null, null, null, null);
    }

    public Cursor getTaskByTitleAndDay(String title, String day) {
        String[] allColumns = {TaskDBHelper.COLUMN_ID, TaskDBHelper.COLUMN_TITLE, TaskDBHelper.COLUMN_CONTENT, TaskDBHelper.COLUMN_DAY};
        String selection = TaskDBHelper.COLUMN_TITLE + " = ? AND " + TaskDBHelper.COLUMN_DAY + " = ?";
        String[] selectionArgs = {title, day};

        return database.query(TaskDBHelper.TABLE_TASKS, allColumns, selection, selectionArgs, null, null, null);
    }
}
