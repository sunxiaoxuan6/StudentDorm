package com.example.service;

import android.content.Context;

import com.example.dao.RoomDAOImpl;
import com.example.dao.RoomDao;
import com.example.model.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllRooms();
    public void insert(Room room);
    public void modifyRealNumber(Room room);
    public void delete(String roomName);
}
