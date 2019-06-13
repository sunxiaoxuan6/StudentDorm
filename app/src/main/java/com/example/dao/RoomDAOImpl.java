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
    private Context context;
    public RoomDAOImpl(Context context){
        //调用MyDBHelper类的构造方法时，
        //若发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper=new MyDBHelper(context,1);
    }
    @Override
    public List<Room> selectAllRooms() {
        List<Room> rooms=null;
        //1、获取SQLiteDatabase对象
        db=helper.getReadableDatabase();
        //2、查询
        String sql="select*from room";
        Cursor cursor=db.rawQuery(sql,null);
        //3、处理结果
        if(cursor!=null&&cursor.getCount()>0){
            rooms=new ArrayList<>();
            while (cursor.moveToNext()){
                Room room=new Room();
                room.setRoomName(cursor.getString(cursor.getColumnIndex("room_name")));
                room.setExpectNumber(cursor.getInt(cursor.getColumnIndex("expect_number")));

                rooms.add(room);
            }
            //4、关闭cursor
            cursor.close();
        }
        //5、返回
        return rooms;
    }

    @Override
    public Room select(Room room) {
        //1、获取db对象
        db=helper.getWritableDatabase();
        String sql="insert into room values(null,?,?,?,?)";
        db.execSQL(sql,new Object[]{
        room.getRoomName(),
        room.getCost(),
        room.getExpectNumber(),
        room.getRealNumber()});
        //2、执行sql语句
        return null;
    }

    @Override
    public List<Room> selectByCost(int cost) {
        return null;
    }

    @Override
    public void insert(Room room) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void delete(String roomName) {
        //1、获取db对象
        db=helper.getWritableDatabase();
        //2、执行sql
        String sql="delete from room where roomName=?";
        db.execSQL(sql,new Object[]{roomName});
    }
}
