package com.example.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtil extends SQLiteOpenHelper {
    private final String Student_entry="create table student_entry(" +
            "      id int primary key autoincrement not null," +
            "      username varchar(100) not null," +
            "      password varchar(100) not null" +
            ")";
    public DBUtil( Context context, int version) {
        super(context, "dorm.db", null, version);
    }
//1、当app发现没有demo.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Student_entry);
    }
//2、当app发现有demo.db时，而且version有变化时会自动调用onUpgrade更新数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student_entry");
        onCreate(db);
    }
}
