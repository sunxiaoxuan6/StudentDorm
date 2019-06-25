package com.example.model;

import java.io.Serializable;

public class Entering implements Serializable {
    public static final String TBL_Entering = "create table if not exists entering(" +
            "id integer primary key autoincrement," +
            "name varchar(20)," +
            "number integer(20)," +
            "studentName varchar(20)," +
            "occupied integer(20))";

    private int id;
    private String name;
    private int number;
    private String studentName;
    private int occupied;

    public Entering(){

    }
    public Entering(String name, int number, String studentName, int occupied) {
        this.name = name;
        this.number = number;
        this.studentName = studentName;
        this.occupied = occupied;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "Entering{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", studentName='" + studentName + '\'' +
                ", occupied='" + occupied + '\'' +
                '}';
    }
}
