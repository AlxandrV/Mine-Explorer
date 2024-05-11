package com.project;

public class Game {

  private Menu menu;
  private Board board;
  private Player player;

  private boolean gameRunning;

  public Game(Menu menu) {
    this.menu = menu;
    board = new Board(menu.getNbRow(), menu.getNbColumn(), player);

    gameRunning = true;
  }

  public void loop() {
    do {
      System.out.println(board);

      int action = menu.doAction();
      if (action == 0) {
        gameRunning = false;
      }
    } while (gameRunning);
  }

  public boolean isGameRunning() {
    return gameRunning;
  }
}
