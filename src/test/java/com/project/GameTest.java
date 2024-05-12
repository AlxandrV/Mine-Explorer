package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameTest {
  Game game;

  @Mock
  Menu menu;

  @Mock
  Player player;

  @Test
  void loopShouldStopWhenAction0() {
    // given
    Mockito.when(menu.getNbColumn()).thenReturn(3);
    Mockito.when(menu.getNbRow()).thenReturn(3);
    Mockito.when(menu.chooseDirectionToMovePlayer()).thenReturn("z");
    Mockito.when(menu.doAction()).thenReturn(1).thenReturn(-1).thenReturn(0);
    game = new Game(menu, player);

    // when
    game.loop();

    // then
    Assertions.assertEquals(false, game.isGameRunning());

  }
}
