package com.example.dao;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.model.Supervisor;
import com.example.util.MyDBHelper;

import java.util.List;

public class SupervisorDAOImpl implements SupervisorDAO {
    private MyDBHelper helper;
    private SQLiteOpenHelper db;

    public SupervisorDAOImpl(Context context){
        helper = new MyDBHelper(context);
    }
    @Override
    public List<Supervisor> selectAllSupervisors() {
        return null;
    }

    @Override
    public Supervisor select(String name) {
        return null;
    }

    @Override
    public List<Supervisor> selectByCost(int cost) {
        return null;
    }

    @Override
    public void insert(Supervisor supervisor) {

    }

    @Override
    public void update(Supervisor supervisor) {

    }

    @Override
    public void delete(String name) {

    }
}
