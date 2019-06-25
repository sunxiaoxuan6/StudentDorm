package com.example.service;

import com.example.model.Register;

import java.util.List;

public interface RegisterService {
     List<Register> getAllRegister();

     void insert(Register register);
     void modifyRealNumber(Register register);
     void delete(String Name);

    boolean login(Register register);
    boolean repeat(Register register);
    boolean update(Register register,String newPassword);

}
