package com.example.dao;

import com.example.model.Register;

import java.util.List;

public interface RegisterDao {
    //查询所有的用户
    List<Register> selectAllRegister();
    //条件查询
    Register select(String studentId);

    List<Register> selectByCost(int cost);
    //增加用户
    void insert(Register register);
    //修改
    void update(Register register);
    //删除
    void delete(String Name);
}
