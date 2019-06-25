package com.example.model;

import java.io.Serializable;
public class Out implements Serializable {
    public static final String TBL_Out = "create table if not exists out(" +
            "id integer primary key autoincrement," +
            "out_name varchar(20)," +
            "reason varchar(20)," +
            "time varchar(20) ," +
            "back_time varchar(20))";

    private int id;
    private String outName;
    private String reason;
    private String time;
    private String backTime;

    public Out() {

    }

    public Out(String outName, String reason, String time,String backTime) {
        this.outName = outName;
        this.reason = reason;
        this.time = time;
        this.backTime = backTime;
    }

    public static String getTBL_Out() {
        return TBL_Out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String result) {
        this.reason = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    @Override
    public String toString() {
        return "Out{" +
                "id=" + id +
                ", outName='" + outName + '\'' +
                ", result='" + reason + '\'' +
                ", time='" + time + '\'' +
                ", backTime='" + backTime + '\'' +
                '}';
    }
}