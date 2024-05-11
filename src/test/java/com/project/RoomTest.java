package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomTest {

  private Room room;

  @Test
  void toStringShouldDisplayRoom() {
    // given
    room = new Room();

    // when
    String display = room.toString();

    // then
    String expected = "  ";
    Assertions.assertEquals(expected, display);
  }
}
