package com.project;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayerTest {

  public Player player;

  @ParameterizedTest
  @MethodSource
  void moveTest(String direction, int rowPosition, int columnPosition) {
    // given
    Board board = new Board(3, 5);
    player = board.getPlayer();

    // when
    board.getPlayer().move(direction, board.playerPosition(), board.getMatrice());

    // then
    Assertions.assertEquals(board.getMatrice()[rowPosition][columnPosition],
        board.getPlayer().getRoom());
  }

  private static Stream<Arguments> moveTest() {
    return Stream.of(Arguments.of("z", 0, 2), Arguments.of("s", 2, 2), Arguments.of("q", 1, 1),
        Arguments.of("d", 1, 3));
  }
}
