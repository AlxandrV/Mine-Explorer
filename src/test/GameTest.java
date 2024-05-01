package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mineExplorer.Board;
import mineExplorer.Game;

class GameTest {

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void launchTest() {
    Game game = new Game();
    Board board = new Board();
    board.setMatrice(new String[5][7]);


    Board boardExpected = game.launch(board);
    String[][] matriceExpected = boardExpected.getMatrice();

    int row = matriceExpected.length / 2;
    int column = matriceExpected[0].length / 2;

    Assertions.assertEquals("*", matriceExpected[row][column]);
  }

}
