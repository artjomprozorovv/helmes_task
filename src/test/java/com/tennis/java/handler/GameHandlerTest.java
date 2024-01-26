package com.tennis.java.handler;

import com.tennis.java.pojo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameHandlerTest {

    private GameHandler gameHandler;
    Player player1;
    Player player2;

    @BeforeEach
    void setUp() {
         player1 = new Player("Player1");
        player2 = new Player("Player2");
        gameHandler = new GameHandler(player1,player2);

    }

    @Test
    void testDeuce() {

        player1.incrementScore();
        player1.incrementScore();
        player1.incrementScore();

        player2.incrementScore();
        player2.incrementScore();
        player2.incrementScore();

        player1.incrementScore(); // Player1 reaches 40
        player2.incrementScore(); // Player2 reaches 40

        gameHandler.startGame(player1, player2);

        assertFalse(gameHandler.getGameStatus().isAdvantage());
        assertFalse(gameHandler.getGameStatus().isGameFinished());
        assertTrue(gameHandler.getGameStatus().isDeuce());
    }

    @Test
    void testAdvantageForPlayer1IfPlayerNotReachedDeuce() {

        player1.incrementScore();
        player1.incrementScore();
        player1.incrementScore();

        player2.incrementScore();
        player2.incrementScore();

        gameHandler.startGame(player1, player2);

        assertFalse(gameHandler.getGameStatus().isAdvantage());
        assertFalse(gameHandler.getGameStatus().isGameFinished());
        assertFalse(gameHandler.getGameStatus().isDeuce());
    }



    @Test
    void testGameFinishWithPlayer2Winning() {
        player1.incrementScore();
        player1.incrementScore();
        player1.incrementScore();
        player1.incrementScore();

        player2.incrementScore();
        player2.incrementScore();

        gameHandler.startGame(player1, player2);

        assertTrue(gameHandler.getGameStatus().isGameFinished());
        assertEquals(1, player1.getGamesWon());
        assertEquals(0, player2.getGamesWon());
    }

    @Test
    void testGameHandlerInitialization() {
        assertNotNull(gameHandler);
        assertNotNull(gameHandler.getPlayer());
        assertNotNull(gameHandler.getPlayer2());
        assertNotNull(gameHandler.getGameStatus());
        assertEquals(1, gameHandler.getGameSetCount());
    }
}