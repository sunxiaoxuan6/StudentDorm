package com.example.service;

import com.example.model.Register;
import com.example.model.Room;

import java.util.List;

public interface RegisterService {
    public List<Register> getAllRegister();
    public void insert(Register register);
    public void modifyRealNumber(Register register);
    public void delete(String Name);
}
