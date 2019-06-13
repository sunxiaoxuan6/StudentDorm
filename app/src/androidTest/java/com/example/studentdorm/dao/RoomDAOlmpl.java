package com.example.studentdorm.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentdorm.model.Room;
import com.example.studentdorm.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOlmpl implements RoomDao {
    private DBHelper helper;
    private SQLiteDatabase db;

    public RoomDAOlmpl(Context context){
//        调用DBHelper类的构造方法时，
//        若发现demo，db不存在会调用onCreate创建
//        若发现demo，db存在，且version的版本与已经有的不一致，则调用onUpgrade方法更新
        helper = new DBHelper(context,1);
    }

    @Override
    public List<Room> selectAllRooms() {
        List<Room> rooms = null;
//        1.获取SQLDatabase对象
        db = helper.getReadableDatabase();
//        2.查询
        String sql ="select * from t_room";
        Cursor cursor = db.rawQuery(sql,null);

//        3.处理结果
        if(cursor!=null && cursor.getCount() > 0){
            rooms = new ArrayList<>();
            while (cursor.moveToNext()){
                Room room = new Room();
                room.setRoomName(cursor.getString(cursor.getColumnIndex("room_name")));
                room.setRooomSex(cursor.getString(cursor.getColumnIndex("room_sex")));
                room.setExpectNumber(cursor.getInt(cursor.getColumnIndex("expect_number")));
                room.setRealNumber(cursor.getInt(cursor.getColumnIndex("real_number")));
                room.setCost(cursor.getInt(cursor.getColumnIndex("cost")));
                room.setRemark(cursor.getString(cursor.getColumnIndex("remark")));





                rooms.add(room);

            }
        }
//        4.返回
        return null;
    }

    @Override
    public void insert(Room room) {
//        1.获取db对象
        db = helper.getWritableDatabase();
        String sql = "insert into t_room values(null,?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]
                {room.getRoomName(),
                room.getRooomSex(),
                room.getExpectNumber(),
                room.getRealNumber(),
                room.getCost(),
                room.getRemark()});
//        2.执行sql



    }

    @Override
    public void uodate(Room room) {
        String sql = "update t_room set real_number=? where room_name=?";
        db.execSQL(sql,new Object[]
                {room.getRoomName(), room.getRealNumber(),});

    }

    @Override
    public void delete(String roomName) {
        db = helper.getWritableDatabase();
        String sql = "delete from t_room where room_name=?";
        db.execSQL(sql,new Object[]{roomName});

    }
}
