package com.example.service;

import android.content.Context;

import com.example.dao.EnteringDAOImpl;
import com.example.dao.EnteringDao;
import com.example.dao.RoomDAOImpl;
import com.example.model.Entering;

import java.util.List;

public class EnteringServiceImpl implements EnteringService{
    private EnteringDao enteringDao;

    public EnteringServiceImpl(Context context){
        enteringDao=new EnteringDAOImpl(context);
    }
    @Override
    public List<Entering> getAllEntering() {
        return enteringDao.selectAllRooms();
    }

    @Override
    public void insert(Entering entering) {
        enteringDao.insert(entering);
    }

    @Override
    public void modifyRealNumber(Entering entering) {
        enteringDao.update(entering);
    }

    @Override
    public void delete(String name) {
        enteringDao.delete(name);
    }
}
