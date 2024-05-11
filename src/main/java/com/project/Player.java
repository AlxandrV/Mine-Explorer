package com.project;

public class Player {

    private Room room;

    public Player(Room room) {
        setRoom(room);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
