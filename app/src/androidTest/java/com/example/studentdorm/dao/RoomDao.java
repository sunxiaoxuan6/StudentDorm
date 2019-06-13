package com.example.studentdorm.dao;

import com.example.studentdorm.model.Room;

import java.util.List;

public interface RoomDao {
//    查询所有的宿舍
    List<Room> selectAllRooms();
//    Room select(String roomName);
//    List<Room> selectByCost(int cost);
    //    添加一个宿舍
    void insert(Room room);
    void uodate(Room room);
    void delete(String roomName);

}
