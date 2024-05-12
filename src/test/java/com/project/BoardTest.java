package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BoardTest {

  Board board;

  @Mock
  Player player;

  @Test
  void toStringShouldDisplayBoard() {
    // given
    board = new Board(2, 3, null);
    board.initMatrice();

    // when
    String result = board.toString();

    // then
    String expected = "      \n      ";
    Assertions.assertEquals(expected, result);
  }

  @Test
  void toStringShouldDisplayPlayerInMiddleOfBoardOnInit() {
    // given
    Mockito.doAnswer(invocation -> {
      Coordinate coordinate = invocation.getArgument(0);
      board.getMatrice()[coordinate.getY()][coordinate.getX()].playerEnterRoom(player);
      return null;
    }).when(player).setCoordinate(ArgumentMatchers.any(Coordinate.class));
    Mockito.when(player.toString()).thenReturn("♛♛");

    // when
    board = new Board(3, 3, player);
    board.initMatrice();
    String result = board.toString();

    // then
    String expected = "      \n  ♛♛  \n      ";
    Assertions.assertEquals(expected, result);
  }
}
