package com.example.model;

import java.io.Serializable;

public class Register implements Serializable {
    public static final String TBL_Register = "create table if not exists register(" +
            "id integer primary key autoincrement," +
            "name varchar(20)," +
            "student_id varchar(20)," +
            "password varchar(20)," +
            "second_password varchar(20))";

    private int id;
    private String name;
    private String studentId;
    private String password;
    private String secondPassword;

    public Register(){

    }
    public Register(String name, String studentId, String password, String secondPassword) {
        this.name = name;
        this.studentId = studentId;
        this.password = password;
        this.secondPassword = secondPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                ", secondPassword='" + secondPassword + '\'' +
                '}';
    }
}
