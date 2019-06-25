package com.example.dao;

import com.example.model.Entering;
import com.example.model.Room;

import java.util.List;

public interface EnteringDao {
    //查询所有的宿舍
    List<Entering> selectAllRooms();
    //条件查询
    Entering select(String roomName);

    List<Entering> selectByCost(int cost);
    //增删改一个宿舍
    void insert(Entering entering);
    void update(Entering entering);
    void delete(String name);
}
