package com.example.service;

import android.content.Context;

import com.example.dao.RegisterDAOImpl;
import com.example.dao.RegisterDao;
import com.example.model.Register;

import java.util.List;

public class RegisterServiceImpl implements RegisterService {
    RegisterDao registerDao;

    public RegisterServiceImpl(Context context){
        registerDao=new RegisterDAOImpl(context);
    }
    @Override
    public List<Register> getAllRegister() {
        return registerDao.selectAllRegister();
    }

    @Override
    public void insert(Register register) {
        registerDao.insert(register);
    }

    @Override
    public void modifyRealNumber(Register register) {
        registerDao.update(register);
    }

    @Override
    public void delete(String Name) {
        registerDao.delete(Name);
    }
}
