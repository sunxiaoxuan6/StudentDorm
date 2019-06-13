package com.example.studentdorm.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private final String TBL_ROOM = "create table t_room(" +
            "id int  primary key autoincrement not null," +
            "room_name varchar(20) not null," +
            "room_sex varchar(6) not null," +
            "expect_number int not null," +
            "real_number int not null," +
            "cost int not null," +
            "remark varchar(200) not null)";

    private final String TBL_Floor = "CREATE TABLE IF NOT EXISTS keeper1(" +
            "id int  primary key autoincrement not null," +
            "username int not null ," +
            "password int not null ," +
            "name VARCHAR(100) NOT NULL ," +
            "jobnumber int(10) not null," +
            "sex varchar(10) not null ," +
            "building varchar(10) not null ," +
            "time_data date ," +
            "phone int(15) not null ," +
            " PRIMARY KEY ( id ))";


    public DBHelper( Context context, int version) {
        super(context, "dem0.db", null, version);
    }


//当app发现没有demo，db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_ROOM);
        db.execSQL(TBL_Floor);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists t_room");
        db.execSQL("drop table if exists keeper1");
        onCreate(db);

    }
}
