package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.Room;
import com.example.util.MyDBHelper;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDao{
    private MyDBHelper helper;
    private SQLiteDatabase db;

    public RoomDAOImpl(Context context){
        //调用MyDBHelper类的构造方法时，
        //若发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper=new MyDBHelper(context,1);
    }


    public void insert(Room room) {
        db = helper.getWritableDatabase();
        String sql = "insert into room values(null,?,?,?,?,?)";
        db.execSQL(sql, new Object[]{
                room.getRoomName(),
                room.getExpectNumber(),
                room.getRealNumber(),
                room.getCost(),
                room.getRemark()});
        db.close();
    }

    @Override
    public void update(Room room) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update room set real_number=? where room_name=?";
        db.execSQL(sql, new Object[]{
                room.getRealNumber(),
                room.getRoomName()
        });
    }

    @Override
    public void delete(String roomName) {
        // 1. 获取db对象
        db = helper.getWritableDatabase();
        // 2. 执行sql
        String sql = "delete from room where room_name=?";
        db.execSQL(sql, new Object[]{ roomName });
    }

    public List<Room> selectAllRooms() {
        String sql = "select * from room";
        List<Room> rooms = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            rooms = new ArrayList<>();
            while (cursor.moveToNext()) {
                Room room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setRoomName(cursor.getString(cursor.getColumnIndex("room_name")));
                room.setExpectNumber(cursor.getInt(cursor.getColumnIndex("expect_number")));
                room.setRealNumber(cursor.getInt(cursor.getColumnIndex("real_number")));
                room.setCost(cursor.getInt(cursor.getColumnIndex("cost")));
                room.setRemark(cursor.getString(cursor.getColumnIndex("remark")));

                rooms.add(room);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return rooms;
    }

    @Override
    public Room select(String roomName) {
        String sql = "select * from room where room_name=?";
        Room room = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{roomName});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setRoomName(cursor.getString(cursor.getColumnIndex("room_name")));
                room.setExpectNumber(cursor.getInt(cursor.getColumnIndex("expect_number")));
                room.setRealNumber(cursor.getInt(cursor.getColumnIndex("real_number")));
                room.setCost(cursor.getInt(cursor.getColumnIndex("cost")));
                room.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return room;
    }

    @Override
    public List<Room> selectByCost(int cost) {
        String sql = "select * from room where expect_number > real_number";
        List<Room> rooms = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            rooms = new ArrayList<>();
            while (cursor.moveToNext()) {
                Room room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setRoomName(cursor.getString(cursor.getColumnIndex("room_name")));
                room.setExpectNumber(cursor.getInt(cursor.getColumnIndex("expect_number")));
                room.setRealNumber(cursor.getInt(cursor.getColumnIndex("real_number")));
                room.setCost(cursor.getInt(cursor.getColumnIndex("cost")));
                room.setRemark(cursor.getString(cursor.getColumnIndex("remark")));

                rooms.add(room);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return rooms;
    }
}
