package com.project;

public class Game {

  private Menu menu;
  private Board board;

  private boolean gameRunning;

  public Game(Menu menu) {
    this.menu = menu;
    board = new Board(menu.getNbRow(), menu.getNbColumn());

    gameRunning = true;
  }

  public void loop() {
    do {
      System.out.println(board);

      int action = menu.doAction();
      if (action == 0) {
        gameRunning = false;
      } else if (action == 1) {
        moveToDirection();
      }
    } while (gameRunning);
  }

  public boolean isGameRunning() {
    return gameRunning;
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
