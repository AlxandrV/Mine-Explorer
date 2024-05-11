package com.project;

import java.util.Scanner;

public class Game {

  private Scanner scanner;
  private Board board;
  private Player player;

  public Game(Scanner scanner) {
    this.scanner = scanner;
    this.player = new Player();
  }

  public void loop() {
    boolean gameRunning = true;

    System.out.print("Nombre de ligne : ");
    int nbRow = scanner.nextInt();
    System.out.print("Nombre de colonne : ");
    int nbColumn = scanner.nextInt();

    board = new Board(nbRow, nbColumn, player);

    do {
      System.out.println(board);
      if (menu() == 0) {
        gameRunning = false;
      }
    } while (gameRunning);
  }

  private int menu() {
    String menu = "----------\n" +
        "Actions disponibles :\n" +
        "Quitter[0]\n" +
        "----------\n";

    System.out.println(menu);
    int action = scanner.nextInt();

    return action;
  }
}
