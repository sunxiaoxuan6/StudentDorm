package com.example.studentdorm.model;

import java.io.Serializable;

public class Room implements Serializable {
   private int id;
   private String roomName;
   private String roomSex;
   private int expectNumber;
   private int realNumber;
   private int cost;
   private String remark;

    public Room(String roomName, String roomSex, int expectNumber, int realNumber, int cost, String remark) {
        this.roomName = roomName;
        this.roomSex = roomSex;
        this.expectNumber = expectNumber;
        this.realNumber = realNumber;
        this.cost = cost;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRooomSex() {
        return roomSex;
    }

    public void setRooomSex(String rooomSex) {
        this.roomSex = rooomSex;
    }

    public int getExpectNumber() {
        return expectNumber;
    }

    public void setExpectNumber(int excepyNumber) {
        this.expectNumber = excepyNumber;
    }

    public int getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(int realNumber) {
        this.realNumber = realNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Room{"+
                ", roomName='" + roomName + '\'' +
                ", rooomSex='" + roomSex + '\'' +
                ", excepyNumber=" + expectNumber +
                ", realNumber=" + realNumber +
                ", cost=" + cost +
                ", remark='" + remark + '\'' +
                '}';
    }
}
