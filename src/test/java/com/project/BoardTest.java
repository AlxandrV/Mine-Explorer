package com.project;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BoardTest {

  private Board board;

  @Test
  void toStringTestShouldDisplayBoard() {
    // given
    board = new Board(2, 3);

    // when
    String result = board.toString();

    // then
    String[] expected = {" ()  **  ** \n **  ??  ** ", " **  **  () \n **  ??  ** ",
        " **  **  ** \n ()  ??  ** ", " **  **  ** \n **  ??  () "};
    Assertions.assertTrue(Arrays.asList(expected).contains(result));
  }

  @Test
  void playerPositionTest() {
    // Given
    board = new Board(2, 3);

    // When
    int[] position = board.playerPosition();
    int[] positionExpected = {1, 1};

    // Then
    Assertions.assertArrayEquals(positionExpected, position);
  }

  @ParameterizedTest
  @MethodSource
  void movePlayerTest(String direction, int rowPosition, int columnPosition) {
    // Given
    board = new Board(3, 5);

    // When
    board.movePlayer(direction);

    // Then
    Room[][] matrice = board.getMatrice();
    Player player = board.getPlayer();
    Assertions.assertEquals(matrice[rowPosition][columnPosition], player.getRoom());
  }

  private static Stream<Arguments> movePlayerTest() {
    return Stream.of(Arguments.of("z", 0, 2), Arguments.of("s", 2, 2), Arguments.of("q", 1, 1),
        Arguments.of("d", 1, 3));
  }

  @Test
  void exitPositionTest() {
    // Given
    board = new Board(3, 5);

    // When
    Room[][] matrice = board.getMatrice();
    Boolean[] exitRoom = {matrice[0][0].getExit(), matrice[0][4].getExit(), matrice[2][0].getExit(),
        matrice[2][4].getExit()};

    // Then
    Assertions.assertTrue(Arrays.asList(exitRoom).contains(true));
  }
}
