package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @Test
    void moveTest() {
        // Given
        player = new Player(null);
        Room room = new Room(5);
        // When
        player.setRoom(room);
        // Then
        assertEquals(room, player.getRoom());
    }
}
