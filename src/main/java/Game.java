package main.java;

import java.util.Scanner;

public class Game {

  Board board;

  public static void main(String[] args) {

    Game game = new Game();
    game.launch();
  }

  public void launch() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nombre de ligne : ");
    int row = Integer.parseInt(scanner.nextLine());

    System.out.print("Nombre de colonne : ");
    int column = Integer.parseInt(scanner.nextLine());

    this.board = new Board(row, column);
    this.choiceAction();

    scanner.close();
  }

  public void choiceAction() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\n-----\nActions disponible :\n-----\nTour suivant [1]\nQuitter[0]\n");
    int action = Integer.parseInt(scanner.nextLine());

    String choice = this.action(action);
    System.out.print("\n" + choice);
    if ("Tour suivant".equals(choice)) {
      this.choiceAction();
    }
  }

  public String action(int inputValue) {
    switch (inputValue) {
      case 1:
        if (this.board != null) {
          System.out.print(this.board.toString());
        }
        return "Tour suivant";
      case 0:
        return "Fin de partie";
    }
    return "";
  }

}
