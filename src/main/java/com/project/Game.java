package com.project;

import java.util.Scanner;

public class Game {

  private Scanner scanner;
  private Board board;

  public Game(Scanner scanner) {
    this.scanner = scanner;
  }

  public void loop() {
    boolean gameRunning = true;

    System.out.print("Nombre de ligne : ");
    int nbRow = scanner.nextInt();
    System.out.print("Nombre de colonne : ");
    int nbColumn = scanner.nextInt();

    board = new Board(nbRow, nbColumn);

    do {
      System.out.println(board);
      int action = menu();
      if (action == 0) {
        gameRunning = false;
      } else if (action == 1) {
        moveToDirection();
      }
    } while (gameRunning);
  }

  private int menu() {
    String menu = "----------\n" + "Actions disponibles :\n" + "Quitter[0]\n"
        + "Se déplacer[1] (consomme une grenade)\n" + "----------\n";

    System.out.println(menu);
    int action = scanner.nextInt();

    return action;
  }

  private void moveToDirection() {
    System.out.println("Se déplacer vers :\n" + "Haut : z | Bas : s | Gauche : q | Droite : d");
    String direction = scanner.next();

    int[] position = board.playerPosition();
    Room[][] matrice = board.getMatrice();
    Player player = board.getPlayer();

    switch (direction) {
      case "z":
        player.setRoom(matrice[position[0] - 1][position[1]]);
        break;
      case "s":
        player.setRoom(matrice[position[0] + 1][position[1]]);
        break;
      case "q":
        player.setRoom(matrice[position[0]][position[1] - 1]);
        break;
      case "d":
        player.setRoom(matrice[position[0]][position[1] + 1]);
        break;
    }
  }
}
