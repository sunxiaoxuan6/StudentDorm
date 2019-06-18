package com.example.service;

import android.content.Context;

import com.example.dao.SupervisorDAO;
import com.example.dao.SupervisorDAOImpl;
import com.example.model.Supervisor;

import java.util.List;

public class SupervisorServiceImpl implements SupervisorService{
    private SupervisorDAO supervisorDAO;

    public SupervisorServiceImpl(Context context){
        supervisorDAO =new SupervisorDAOImpl(context);
    }
    @Override
    public List<Supervisor> getAllSupervisors() {
        return supervisorDAO.selectAllSupervisors();
    }

    @Override
    public void insert(Supervisor supervisor) {
        supervisorDAO.insert(supervisor);
    }

    @Override
    public void modifyRealNumber(Supervisor supervisor) {
        supervisorDAO.update(supervisor);
    }

    @Override
    public void delete(String name) {
        supervisorDAO.delete(name);
    }
}
