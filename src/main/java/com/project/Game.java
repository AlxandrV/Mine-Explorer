package com.project;

public class Game {

  private Menu menu;
  private Board board;

  private boolean gameRunning;

  public Game(Menu menu) {
    this.menu = menu;
    board = new Board(menu.getNbRow(), menu.getNbColumn());
    board.initMine(menu.getNbMine());

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
        menu.actionNotif(board.getPlayer().getPlayerState());
        gameRunning = false;
        break;
      case 1:
        String direction = menu.moveToDirection();
        board.getPlayer().move(direction, board.playerPosition(), board.getMatrice());

        if (board.getPlayer().getPlayerState() == PlayerState.EXIT
            || board.getPlayer().getPlayerState() == PlayerState.LOST) {
          menu.actionNotif(board.getPlayer().getPlayerState());
          gameRunning = false;
        }

      default:
        break;
    }
  }

  public boolean isGameRunning() {
    return gameRunning;
  }

}
