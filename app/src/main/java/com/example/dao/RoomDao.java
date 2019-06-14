package com.example.dao;

import com.example.model.Room;
import com.example.model.Student;

import java.util.List;

    public interface RoomDao {
        //查询所有的宿舍
        List<Room> selectAllRooms();
        //条件查询
        Room select(String roomName);

        List<Room> selectByCost(int cost);
        //增删改一个宿舍
        void insert(Room room);
        void update(Room room);
        void delete(String roomName);
    }

