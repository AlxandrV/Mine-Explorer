package com.project;

public class Game {

  private Menu menu;
  private Board board;
  private Player player;

  private boolean gameRunning;

  public Game(Menu menu, Player player) {
    this.menu = menu;
    this.player = player;

    board = new Board(menu.getNbRow(), menu.getNbColumn(), player);
    player.setBoard(board);

    board.initMatrice();
    gameRunning = true;
  }

  public void loop() {
    do {
      System.out.println(board);

      handleAction(menu.doAction());
    } while (gameRunning);
  }

  private void handleAction(int action) {
    switch (action) {
      case 0:
        gameRunning = false;
        break;
      case 1:
        String direction = menu.chooseDirectionToMovePlayer();
        player.moveToDirection(direction);
        break;

      default:
        break;
    }
  }

  public boolean isGameRunning() {
    return gameRunning;
  }
}
