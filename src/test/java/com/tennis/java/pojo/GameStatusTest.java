package com.tennis.java.pojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameStatusTest {

    @Test
    void testDefaultGameStatusInitialization() {
        GameStatus gameStatus = new GameStatus(false, false, false);

        assertFalse(gameStatus.isDeuce());
        assertFalse(gameStatus.isAdvantage());
        assertFalse(gameStatus.isGameFinished());
    }

}
