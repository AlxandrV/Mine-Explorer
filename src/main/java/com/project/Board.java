package com.project;

public class Board {

  private Room[][] matrice;
  private int nbRow;
  private int nbColumn;

  public Board(int nbRow, int nbColumn, Player player) {
    this.nbRow = nbRow;
    this.nbColumn = nbColumn;

    initMatrice(player);
  }

  private void initMatrice(Player player) {
    matrice = new Room[nbRow][nbColumn];
    for (int i = 0; i < nbRow; i++) {
      for (int j = 0; j < nbColumn; j++) {
        matrice[i][j] = new Room();
      }
    }

    matrice[nbRow / 2][nbColumn / 2].playerEnterRoom(player);
  }

  @Override
  public String toString() {
    String display = "";

    for (int i = 0; i < nbRow; i++) {
      for (int j = 0; j < nbColumn; j++) {
        display += matrice[i][j];
      }
      if (i < nbRow - 1) {
        display += "\n";
      }
    }

    return display;
  }
}
