package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

  private Player player;

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
}
