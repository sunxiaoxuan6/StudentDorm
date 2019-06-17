package com.example.service;

import com.example.model.Supervisor;

import java.util.List;

public interface SupervisorService {
    public List<Supervisor> getAllSupervisors();
    public void insert(Supervisor supervisor);
    public void modifyRealNumber(Supervisor supervisor);
    public void delete(String name);
}
