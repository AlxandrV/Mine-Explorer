package com.project;

import java.util.Optional;
import java.util.Random;
import com.project.Items.Detector;
import com.project.Items.Exit;
import com.project.Items.Mine;

public class Board {

  private Room[][] matrice;
  private int nbRow;
  private int nbColumn;

  public int getNbRow() {
    return nbRow;
  }

  public int getNbColumn() {
    return nbColumn;
  }

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
    addExitRandom(matrice);
    addDetectorRandom();
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

  public void movePlayer(String direction) {
    int[] position = playerPosition();
    Player player = getPlayer();
    Room[][] matrice = getMatrice();
    player.move(direction, position, matrice);
  }

  private void addExitRandom(Room[][] matrice) {
    int roomRandom = (int) (Math.random() * 4);
    int i, j;
    switch (roomRandom) {
      case 0:
        i = 0;
        j = 0;
        break;
      case 1:
        i = 0;
        j = nbColumn - 1;
        break;
      case 2:
        i = nbRow - 1;
        j = 0;
        break;
      case 3:
        i = nbRow - 1;
        j = nbColumn - 1;
        break;
      default:
        throw new IllegalArgumentException("Valeur de coinAleatoire invalide.");
    }

    matrice[i][j].setItem(new Exit());
  }

  public void initMine(int nbMine) {
    int count = 0;
    Random random = new Random();

    while (count < nbMine) {
      int i = random.nextInt(nbRow);
      int j = random.nextInt(nbColumn);

      Optional<Room> room = getRoomByCoordinate(i, j);

      if (room.get().getItem() == null) {
        room.get().setItem(new Mine());
        count++;
      }
    }
  }

  public void addDetectorRandom() {
    Random random = new Random();
    Boolean dontHasDetector = true;

    while (dontHasDetector) {
      int i = random.nextInt(nbRow);
      int j = random.nextInt(nbColumn);

      Optional<Room> room = getRoomByCoordinate(i, j);

      if (room.get().getItem() == null) {
        room.get().setItem(new Detector());
        dontHasDetector = false;
      }
    }
  }

  public Optional<Room> getRoomByCoordinate(int x, int y) {
    return Optional.ofNullable(matrice[x][y]);
  }

  @Override
  public String toString() {
    String display = "";
    int[] playerPosition = playerPosition();

    for (int i = 0; i < nbRow; i++) {
      for (int j = 0; j < nbColumn; j++) {
        if (i == playerPosition[0] && j == playerPosition[1]) {
          display += " " + player.display() + " ";
        } else {
          display += " " + matrice[i][j].display() + " ";
        }
      }
      if (i < nbRow - 1) {
        display += "\n";
      }
    }

    return display;
  }
}
