package com.project;

import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.project.Items.Detector;
import com.project.Items.Exit;
import com.project.Items.Mine;

class BoardTest {

  private Board board;

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

  // @ParameterizedTest
  // @MethodSource
  // void movePlayerTest(String direction, int rowPosition, int columnPosition) {
  // // Given
  // board = new Board(3, 5);

  // // When
  // board.movePlayer(direction);

  // // Then
  // Room[][] matrice = board.getMatrice();
  // Player player = board.getPlayer();
  // Assertions.assertEquals(matrice[rowPosition][columnPosition], player.getRoom());
  // }

  // private static Stream<Arguments> movePlayerTest() {
  // return Stream.of(Arguments.of("z", 0, 2), Arguments.of("s", 2, 2), Arguments.of("q", 1, 1),
  // Arguments.of("d", 1, 3));
  // }

  @Test
  void exitPositionTest() {
    // Given
    board = new Board(3, 5);

    // When
    Item[] exitRoom = {board.getMatrice()[0][0].getItem(),
        board.getMatrice()[0][board.getNbColumn() - 1].getItem(),
        board.getMatrice()[board.getNbRow() - 1][0].getItem(),
        board.getMatrice()[board.getNbRow() - 1][board.getNbColumn() - 1].getItem()};

    Boolean containsExit = Arrays.stream(exitRoom).anyMatch(item -> item instanceof Exit);
    int nbExit = countObjects(Exit.class);

    // Then
    Assertions.assertEquals(1, nbExit);
    Assertions.assertTrue(containsExit);
  }

  @Test
  void containsMineTest() {
    // Given
    board = new Board(3, 5);

    // When
    board.initMine(3);

    // Then
    Assertions.assertEquals(3, countObjects(Mine.class));
  }

  @Test
  void containsExitTest() {
    // Given
    board = new Board(3, 5);

    // When
    board.initMine(3);

    // Then
    Assertions.assertEquals(1, countObjects(Exit.class));
  }

  @Test
  void initDetectorTest() {
    // Given
    board = new Board(3, 5);

    // Then
    Assertions.assertEquals(1, countObjects(Detector.class));
  }

  @Test
  void getRoomByCoordinateTest() {
    // Given
    board = new Board(2, 3);

    // When
    Optional<Room> room = board.getRoomByCoordinate(1, 2);

    // Then
    Assertions.assertEquals(board.getMatrice()[1][2], room.get());
  }

  private int countObjects(Class<?> clazz) {
    int count = 0;
    for (int x = 0; x < board.getNbRow(); x++) {
      for (int y = 0; y < board.getNbColumn(); y++) {
        Optional<Room> roomOptional = board.getRoomByCoordinate(x, y);
        if (roomOptional.isPresent() && clazz.isInstance(roomOptional.get().getItem())) {
          count++;
        }
      }
    }
    return count;
  }
}
