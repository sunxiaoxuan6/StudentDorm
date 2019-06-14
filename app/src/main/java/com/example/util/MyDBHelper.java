package com.example.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private final String TBL_ROOM = "create table room(" +
            "id int  primary key autoincrement not null," +
            "room_name varchar(20) not null," +
            "expect_number int not null," +
            "real_number int not null," +
            "cost int not null)";

    public MyDBHelper( Context context, int version) {
        super(context, "dorm.db", null, version);
    }
    //当app发现没有dorm.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_ROOM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists room");
        onCreate(db);
    }
}
