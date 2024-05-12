package com.project;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlayerTest {

  Player player;

  @Mock
  Board board;

  @Test
  void toStringShouldDisplayPlayer() {
    // given
    player = new Player();

    // when
    String display = player.toString();

    // then
    String expected = "♛♛";
    Assertions.assertEquals(expected, display);
  }

  @ParameterizedTest
  @MethodSource
  void playerCanMove(String direction, Coordinate coordinateExpected) {
    // given
    Room[][] matrice = new Room[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matrice[i][j] = new Room();
      }
    }
    Mockito.when(board.getMatrice()).thenReturn(matrice);
    player = new Player();
    player.setBoard(board);
    player.setCoordinate(new Coordinate(1, 1));

    // when
    player.moveToDirection(direction);

    // then
    Assertions.assertEquals(coordinateExpected, player.getCoordinate());
  }

  private static Stream<Arguments> playerCanMove() {
    return Stream.of(
        Arguments.of("z", new Coordinate(1, 0)),
        Arguments.of("q", new Coordinate(0, 1)),
        Arguments.of("s", new Coordinate(1, 2)),
        Arguments.of("d", new Coordinate(2, 1)),
        Arguments.of("?", new Coordinate(1, 1)));
  }
}
