package com.example.dao;

import com.example.model.Register;
import com.example.model.Room;

import java.util.List;

public interface RegisterDao {
    //查询所有的用户
    List<Register> selectAllRegister();
    //条件查询
    Register select(String studentId);

    List<Register> selectByCost(int cost);
    //增删改一个用户
    void insert(Register register);
    void update(Register register);
    void delete(String Name);
}
