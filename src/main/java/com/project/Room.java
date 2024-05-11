package com.project;

public class Room {
  private final String symbol = "  ";

  private Player player;

  public void playerEnterRoom(Player player) {
    this.player = player;
  }

  public void playerLeaveRoom() {
    this.player = null;
  }

  @Override
  public String toString() {
    if (player != null) {
      return player.toString();
    }
    return symbol;
  }

}
