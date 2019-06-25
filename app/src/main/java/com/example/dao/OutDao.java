package com.example.dao;

import com.example.model.Out;


import java.util.List;

public interface OutDao {
    //查询所有的宿舍
    List<Out> selectAllOuts();
    //条件查询
    Out select(String outName);

    List<Out> selectByCost(int cost);
    //增删改一个宿舍
    void insert(Out out);
    void update(Out out);
    void delete(String outName);
}

