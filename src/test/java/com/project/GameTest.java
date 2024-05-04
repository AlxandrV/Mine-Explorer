package com.project;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class GameTest {

  private Game game;

  private Scanner scanner;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    game = new Game(scannerMock);
  }

  @Test
  void loopTest() {
    // given
    // when
    game.loop();
    // then
  }
}
