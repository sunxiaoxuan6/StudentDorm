package com.example.dao;

import com.example.model.Room;
import com.example.model.Supervisor;

import java.util.List;

public interface SupervisorDAO {

    List<Supervisor> selectAllSupervisors();
    Supervisor select(String name);

    List<Supervisor> selectByCost(int cost);
    void insert(Supervisor supervisor);
    void update(Supervisor supervisor);
    void delete(String name);
}
