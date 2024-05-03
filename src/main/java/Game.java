package main.java;

import java.util.Scanner;

public class Game {

  private Scanner scanner;
  private Board board;

  Game() {
    scanner = new Scanner(System.in);
  }

  public static void main(String[] args) {
    Game game = new Game();
    game.loop();

  }

  private void loop() {
    boolean gameRunning = true;

    System.out.print("Nombre de ligne : ");
    int nbRow = scanner.nextInt();
    System.out.print("Nombre de colonne : ");
    int nbColumn = scanner.nextInt();

    board = new Board(nbRow, nbColumn);

    do {
      System.out.println(board);
      if (menu() == 0) {
        gameRunning = false;
      }
    } while (gameRunning);

    scanner.close();
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
