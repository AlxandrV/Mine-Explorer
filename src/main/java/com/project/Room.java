package com.project;

public class Room {

    int id;
    Boolean exit;

    public Room(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setExit(Boolean exit) {
        this.exit = exit;
    }

    public Boolean getExit() {
        return this.exit;
    }

    public String display() {
        return exit == true ? "()" : "**";
    }
}
