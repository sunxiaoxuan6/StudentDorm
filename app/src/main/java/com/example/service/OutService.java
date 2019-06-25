package com.example.service;

import com.example.model.Out;

import java.util.List;

public interface OutService {
    public List<Out> getAllOuts();
    public void insert(Out out);
    public void modifyRealNumber(Out out);
    public void delete(String outName);
}
