package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.Board;

class BoardTest {

  private Board board;

  @Test
  void toStringTestShouldDisplayBoard() {
    // given
    board = new Board(2, 3);

    // when
    String result = board.toString();

    // then
    String expected = "***\n***";
    Assertions.assertEquals(expected, result);
  }
}
