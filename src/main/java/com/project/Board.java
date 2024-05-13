package com.project;

public class Board {

  private Room[][] matrice;
  private int nbRow;
  private int nbColumn;
  private Player player;

  public Board(int nbRow, int nbColumn) {
    this.nbRow = nbRow;
    this.nbColumn = nbColumn;

    initMatrice();
  }

  public Room[][] getMatrice() {
    return matrice;
  }

  public void setMatrice(Room[][] matrice) {
    this.matrice = matrice;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  private void initMatrice() {
    matrice = new Room[nbRow][nbColumn];
    int middleRow = nbRow / 2;
    int middleCol = nbColumn / 2;
    int id = 0;
    for (int i = 0; i < nbRow; i++) {
      for (int j = 0; j < nbColumn; j++) {
        id++;
        matrice[i][j] = new Room(id);
        if (i == middleRow && j == middleCol) {
          initPlayer(matrice[i][j]);
        }
      }
    }
  }

  private void initPlayer(Room room) {
    player = new Player(room);
  }

  public int[] playerPosition() {
    Room[][] matrice = getMatrice();
    int row = searchRow(matrice, player.getRoom().getId());

    if (row != -1) {
      for (int j = 0; j < nbColumn; j++) {
        if (matrice[row][j] == player.getRoom()) {
          int[] position = {row, j};
          return position;
        }
      }
    }

    return null;
  }

  private int searchRow(Room[][] matrice, int element) {
    int start = 0;
    int end = nbRow - 1;

    while (start <= end) {
      int middle = (start + end) / 2;
      if (matrice[middle][0].getId() <= element
          && element <= matrice[middle][nbColumn - 1].getId()) {
        return middle;
      }
      if (matrice[middle][0].getId() > element) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }
    return -1;
  }

  @Override
  public String toString() {
    String display = "";

    for (int i = 0; i < nbRow; i++) {
      for (int j = 0; j < nbColumn; j++) {
        display += " " + matrice[i][j].display() + " ";
      }
      if (i < nbRow - 1) {
        display += "\n";
      }
    }

    return display;
  }
}
