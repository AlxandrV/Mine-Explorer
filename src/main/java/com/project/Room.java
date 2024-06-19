package com.project;

public class Room {

    int id;
    Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Room(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String display() {
        return this.item != null ? this.item.display() : "**";
    }
}
