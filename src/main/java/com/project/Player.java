package com.project;

import com.project.Items.Exit;
import com.project.Items.Mine;

public class Player {

    private Room room;
    private PlayerState playerState;

    public Player(Room room) {
        playerState = PlayerState.PLAYING;
        setRoom(room);
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void move(String direction, int[] position, Room[][] matrice) {
        int[] matriceDirection = new int[2];

        switch (direction) {
            case "z":
                matriceDirection[0] = -1;
                matriceDirection[1] = 0;
                break;
            case "s":
                matriceDirection[0] = 1;
                matriceDirection[1] = 0;
                break;
            case "q":
                matriceDirection[0] = 0;
                matriceDirection[1] = -1;
                break;
            case "d":
                matriceDirection[0] = 0;
                matriceDirection[1] = 1;
                break;
            default:
                matriceDirection[0] = 0;
                matriceDirection[1] = 0;
                break;
        }

        setRoom(matrice[position[0] + matriceDirection[0]][position[1] + matriceDirection[1]]);

        if (getRoom().getItem() instanceof Exit) {
            setPlayerState(PlayerState.EXIT);
        } else if (getRoom().getItem() instanceof Mine) {
            setPlayerState(PlayerState.LOST);
        }
    };

    public String display() {
        return "??";
    }
}
