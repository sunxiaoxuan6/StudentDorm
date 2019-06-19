package com.example.model;

import java.io.Serializable;

public class Supervisor implements Serializable {
    public static final String TBL_SUPERVISOR = "create table if not exists supervisor("+
            "id integer primary key autoincrement," +
            "name varchar(20)," +
            "job_number int," +
            "sex varchar(20)," +
            "build_number int," +
            "job_hour integer,"+
            "contact varchar(20)," +
            "remark varchar(20)," +
            "room integer," +
            "period integer)";

    private int id;
    private String name;
    private int job_number;
    private String sex;
    private int build_number;
    private int job_hour;
    private String contact;
    private String remark;
    private int room;
    private int period;

    public Supervisor(){

    }

    public Supervisor(String name, int job_number, String sex, int build_number, int job_hour, String contact, String remark, int room, int period) {
        this.name = name;
        this.job_number = job_number;
        this.sex = sex;
        this.build_number = build_number;
        this.job_hour = job_hour;
        this.contact = contact;
        this.remark = remark;
        this.room = room;
        this.period = period;
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

    public int getJob_number() {
        return job_number;
    }

    public void setJob_number(int job_number) {
        this.job_number = job_number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBuild_number() {
        return build_number;
    }

    public void setBuild_number(int build_number) {
        this.build_number = build_number;
    }

    public int getJob_hour() {
        return job_hour;
    }

    public void setJob_hour(int job_hour) {
        this.job_hour = job_hour;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "name='" + name + '\'' +
                ", job_number=" + job_number +
                ", sex='" + sex + '\'' +
                ", build_number=" + build_number +
                ", job_hour=" + job_hour +
                ", contact='" + contact + '\'' +
                ", remark='" + remark + '\'' +
                ", room=" + room +
                ", period=" + period +
                '}';
    }
}
