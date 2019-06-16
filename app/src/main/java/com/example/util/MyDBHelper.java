package com.example.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.model.Room;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context, int version) {
        super(context, "dorm.db", null, version);
    }

    // 当app发现没有demo.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Room.TBL_ROOM);
    }

    // 当app发现有demo.db时，而且version有变化时会自动调用onUpgrade更新数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists room");
        onCreate(db);
    }
}
