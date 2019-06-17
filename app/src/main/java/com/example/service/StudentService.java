package com.example.service;

import com.example.model.Room;
import com.example.model.Student;

import java.util.List;

public interface StudentService {
     List<Student> getAllStudents();
     void insert(Student student);
     void modifyRealNumber(Student student);
     void delete(String StudentName);
}
