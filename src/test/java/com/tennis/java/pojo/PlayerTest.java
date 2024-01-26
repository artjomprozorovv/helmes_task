package com.tennis.java.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @Test
    void testPlayerInitialization() {
        Player player = new Player("John");

        assertNotNull(player);
        assertEquals("John", player.getName());
        assertEquals(0, player.getScore());
        assertEquals(0, player.getGamesWon());
    }

    @Test
    void testIncrementScore() {
        Player player = new Player("Alice");

        assertEquals(0, player.getScore());

        player.incrementScore();
        assertEquals(1, player.getScore());

        player.incrementScore();
        assertEquals(2, player.getScore());
    }
}
