package com.example.service;

import com.example.model.Entering;
import com.example.model.Room;

import java.util.List;

public interface EnteringService {
    public List<Entering> getAllEntering();
    public void insert(Entering entering);
    public void modifyRealNumber(Entering entering);
    public void delete(String name);
}
