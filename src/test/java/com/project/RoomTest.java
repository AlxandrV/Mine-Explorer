package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RoomTest {

  Room room;

  @Mock
  Player player;

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

  @Test
  void playerEntersInRoomShouldDisplayPlayer() {
    // given
    Mockito.when(player.toString()).thenReturn("♛♛");
    room = new Room();

    // when
    room.playerEnterRoom(player);
    String display = room.toString();

    // then
    String expected = "♛♛";
    Assertions.assertEquals(expected, display);
  }

  @Test
  void playerLeavesRoomShouldDisplayRoom() {
    // given
    room = new Room();
    room.playerEnterRoom(player);

    // when
    room.playerLeaveRoom();
    String display = room.toString();

    // then
    String expected = "  ";
    Assertions.assertEquals(expected, display);
  }
}
