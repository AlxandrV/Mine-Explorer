package com.project;

public class Player {
    private int energie;
    private int grenade;
    private Room room;

    public Player(Room room) {
        energie = 10;
        grenade = 10;
        setRoom(room);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
