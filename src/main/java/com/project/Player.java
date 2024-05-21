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

    public void move(String direction, int[] position, Room[][] matrice) {
        switch (direction) {
            case "z":
                setRoom(matrice[position[0] - 1][position[1]]);
                break;
            case "s":
                setRoom(matrice[position[0] + 1][position[1]]);
                break;
            case "q":
                setRoom(matrice[position[0]][position[1] - 1]);
                break;
            case "d":
                setRoom(matrice[position[0]][position[1] + 1]);
                break;
        }
    };

    public String display() {
        return "??";
    }
}
