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

    //判断是否注册成功
    @Override
    public boolean login(Register register) {
        //        1.获取用户信息
        Register user = registerDao.select(register.getName());

//        2.判断
        if (user != null && user.getPassword().equals(register.getPassword())) {
            return true;
        }
        return false;
    }
//判断用户是否存在
    @Override
    public boolean repeat(Register register) {
        //        1.获取用户信息
        Register user = registerDao.select(register.getName());

//        2.判断
        if (user!=null) {
            return true;
        }
        return false;
    }

}
