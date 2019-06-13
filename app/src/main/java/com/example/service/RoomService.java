package com.example.service;

import android.content.Context;

import com.example.dao.RoomDAOImpl;
import com.example.dao.RoomDao;
import com.example.model.Room;

import java.util.List;

public class RoomService {
    private Context context;
    private RoomDao roomDao;

    public RoomService(Context context) {
        this.context = context;
        roomDao=new RoomDAOImpl(context);
    }
    public List<Room> getAllRooms(){
        return roomDao.selectAllRooms();
    }
    public void insert(Room room){
        roomDao.insert(room);
    }
}
