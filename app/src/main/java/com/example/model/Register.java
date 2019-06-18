package com.example.model;

import java.io.Serializable;

public class Register implements Serializable {
    public static final String TBL_Register = "create table if not exists register(" +
            "id integer primary key autoincrement," +
            "name varchar(20)," +
            "student_id integer," +
            "password integer," +
            "second_password integer)";

    private int id;
    private String name;
    private int studentId;
    private int password;
    private int secondPassword;

    public Register(){

    }
    public Register(String name, int studentId, int password, int secondPassword) {
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(int secondPassword) {
        this.secondPassword = secondPassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", password=" + password +
                ", secondPassword=" + secondPassword +
                '}';
    }
}
