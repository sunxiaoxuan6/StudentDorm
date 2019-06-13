package com.example.model;

public class Room {
    private int id;
    private String roomName;
    private int cost;
    private int expectNumber;
    private int realNumber;

    public Room() {

    }

    public Room(String roomName, int cost, int expectNumber, int realNumber) {
        this.roomName = roomName;
        this.cost = cost;
        this.expectNumber = expectNumber;
        this.realNumber = realNumber;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getExpectNumber() {
        return expectNumber;
    }

    public void setExpectNumber(int expectNumber) {
        this.expectNumber = expectNumber;
    }

    public int getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(int realNumber) {
        this.realNumber = realNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", cost=" + cost +
                ", expectNumber=" + expectNumber +
                ", realNumber=" + realNumber +
                '}';
    }
}
