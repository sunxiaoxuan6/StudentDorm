package com.example.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.model.Register;
import com.example.model.Room;
import com.example.model.Student;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context) {
        super(context, "dorm.db", null, 6);
    }

    // 当app发现没有dorm.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Room.TBL_ROOM);
        db.execSQL(Student.TBL_Student);
        db.execSQL(Register.TBL_Register);
    }

    // 当app发现有dorm.db时，而且version有变化时会自动调用onUpgrade更新数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists room");
        db.execSQL("drop table if exists student");
        db.execSQL("drop table if exists register");
        onCreate(db);
    }
}
