package test;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import main.java.Game;

class GameTest {

  @ParameterizedTest
  @MethodSource
  void actionsTest(int inputValue, String expectedValue) {
    // Given
    Game game = new Game();
    // When
    String action = game.action(inputValue);
    // Then
    Assertions.assertEquals(expectedValue, action);
  }

  private static Stream<Arguments> actionsTest() {
    return Stream.of(Arguments.of(1, "Tour suivant"), Arguments.of(0, "Fin de partie"),
        Arguments.of(6, ""));
  }
}
