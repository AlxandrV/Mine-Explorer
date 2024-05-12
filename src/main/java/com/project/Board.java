package com.project;

public class Board {

  private Room[][] matrice;
  private int nbRow;
  private int nbColumn;

  private Player player;

  public Board(int nbRow, int nbColumn, Player player) {
    this.nbRow = nbRow;
    this.nbColumn = nbColumn;
    this.player = player;
  }

  public void initMatrice() {
    matrice = new Room[nbRow][nbColumn];
    for (int y = 0; y < nbRow; y++) {
      for (int x = 0; x < nbColumn; x++) {
        matrice[y][x] = new Room();
      }
    }

    if (player != null)
      player.setCoordinate(new Coordinate(nbColumn / 2, nbRow / 2));
  }

  public Room[][] getMatrice() {
    return matrice;
  }

  @Override
  public String toString() {
    String display = "";

    for (int y = 0; y < nbRow; y++) {
      for (int x = 0; x < nbColumn; x++) {
        display += matrice[y][x];
      }
      if (y < nbRow - 1) {
        display += "\n";
      }
    }

    return display;
  }
}
