package com.project;

public class Room {

    int id;

    public Room(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String display() {
        return "**";
    }
}
