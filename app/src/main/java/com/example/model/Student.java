package com.example.model;

import java.io.Serializable;

public class Student implements Serializable {
    public static final String TBL_Student = "create table if not exists student(" +
            "id integer primary key autoincrement," +
            "name varchar(20)," +
            "student_id integer," +
            "sex varchar(20)," +
            "dorm_id integer," +
            "faculty varchar(20)," +
            "class1 varchar(20)," +
            "educational integer," +
            "start_time varchar(20),"+
            "contact varchar(200))";

    private int id;
    private String name;
    private int student_id;
    private String sex;
    private int dorm_id;
    private String faculty;
    private String class1;
    private int educational;
    private String  start_time;
    private String  contact;

    public Student(){

    }
    public Student(String name, int student_id, String sex, int dorm_id, String faculty, String class1, int educational, String start_time, String contact) {
        this.name = name;
        this.student_id = student_id;
        this.sex = sex;
        this.dorm_id = dorm_id;
        this.faculty = faculty;
        this.class1 = class1;
        this.educational = educational;
        this.start_time = start_time;
        this.contact = contact;
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

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(int dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public int getEducational() {
        return educational;
    }

    public void setEducational(int educational) {
        this.educational = educational;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", student_id=" + student_id +
                ", sex='" + sex + '\'' +
                ", dorm_id=" + dorm_id +
                ", faculty='" + faculty + '\'' +
                ", class1='" + class1 + '\'' +
                ", educational=" + educational +
                ", start_time='" + start_time + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
