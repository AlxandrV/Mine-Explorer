package com.project;

import com.project.Items.Exit;
import com.project.Items.Mine;

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

      int action = menu.doAction();
      if (action == 0) {
        gameRunning = false;
      } else if (action == 1) {
        String direction = menu.moveToDirection();
        board.movePlayer(direction);
        if (board.getPlayer().getRoom().getItem() instanceof Exit
            || board.getPlayer().getRoom().getItem() instanceof Mine) {
          gameRunning = false;
        }
      }
    } while (gameRunning);
  }

  public boolean isGameRunning() {
    return gameRunning;
  }

}
