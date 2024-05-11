package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    // when
    String result = board.toString();

    // then
    String expected = "      \n      ";
    Assertions.assertEquals(expected, result);
  }

  @Test
  void toStringShouldDisplayPlayerInMiddleOfBoardOnInit() {
    // given
    Mockito.when(player.toString()).thenReturn("♛♛");
    board = new Board(3, 3, player);

    // when
    String result = board.toString();

    // then
    String expected = "      \n  ♛♛  \n      ";
    Assertions.assertEquals(expected, result);
  }
}
