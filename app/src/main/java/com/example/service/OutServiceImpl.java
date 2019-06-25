package com.example.service;

import android.content.Context;

import com.example.dao.OutDAOImpl;
import com.example.dao.OutDao;
import com.example.dao.RoomDAOImpl;
import com.example.dao.RoomDao;
import com.example.model.Out;
import com.example.model.Room;

import java.util.List;

public class OutServiceImpl implements OutService {
    private OutDao outDao;
    public OutServiceImpl(Context context){
        outDao = new OutDAOImpl(context);
    }
    @Override
    public List<Out> getAllOuts() {
        return outDao.selectAllOuts();
    }

    @Override
    public void insert(Out out) {
        outDao.insert(out);
    }

    @Override
    public void modifyRealNumber(Out out) {
        outDao.update(out);

    }

    @Override
    public void delete(String outName) {
        outDao.delete(outName);
    }
}
