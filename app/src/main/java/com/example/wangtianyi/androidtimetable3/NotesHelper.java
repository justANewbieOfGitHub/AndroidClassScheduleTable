package com.example.wangtianyi.androidtimetable3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2019/5/27.
 */

public class NotesHelper extends SQLiteOpenHelper {

    public NotesHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table notes(" +
                "id integer primary key autoincrement," +
                "text text," +
                "texttime text," +
                "alarm text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
