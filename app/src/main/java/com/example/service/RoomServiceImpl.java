package com.example.service;

import android.content.Context;

import com.example.dao.RoomDAOImpl;
import com.example.dao.RoomDao;
import com.example.model.Room;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private RoomDao roomDao;

    public RoomServiceImpl(Context context){
        roomDao=new RoomDAOImpl(context);
    }
    @Override
    public List<Room> getAllRooms() {
        return roomDao.selectAllRooms();
    }

    @Override
    public void insert(Room room) {
        roomDao.insert(room);
    }

    @Override
    public void modifyRealNumber(Room room) {
        roomDao.update(room);
    }

    @Override
    public void delete(String roomName) {
        roomDao.delete(roomName);
    }
}
