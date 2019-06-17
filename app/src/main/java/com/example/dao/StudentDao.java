package com.example.dao;

import com.example.model.Room;
import com.example.model.Student;

import java.util.List;

public interface StudentDao {
    //查询所有的学生
    List<Student> selectAllStudents();
    //条件查询
    Student select(String student);

    List<Student> selectByCost(int cost);
    //增删改一个学生
    void insert(Student student);
    void update(Student student);
    void delete(String studentName);
}
