package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.Board;
import main.java.Game;

class GameTest {

  @Test
  void launchTest() {
    Game game = new Game();
    Board board = new Board(5, 7);

    Board boardExpected = game.launch(board);
    String[][] matriceExpected = boardExpected.getMatrice();

    int row = matriceExpected.length / 2;
    int column = matriceExpected[0].length / 2;

    Assertions.assertEquals("*", matriceExpected[row][column]);
  }
}
