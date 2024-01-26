package com.tennis.java.handler;

import com.tennis.java.pojo.GameStatus;
import com.tennis.java.pojo.Player;
import lombok.Getter;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class GameHandler {

    private final static Logger logger = LoggerFactory.getLogger(GameHandler.class);

    private final Player player;
    private final Player player2;
    private int gameSetCount;
    private final int MINIMUM_SCORE_TO_WIN = 4;
    private final GameStatus gameStatus;
    private final Scanner scanner = new Scanner(System.in);


    public GameHandler(Player player, Player player2) {
        this.player = player;
        this.player2 = player2;
        this.gameSetCount = 1;
        this.gameStatus = new GameStatus(false, false, false);
    }


    public void startGame(Player player1, Player player2) {
        if (isGameFinished(player1, player2)) {
            handleGameFinish(player1, player2);
        } else {
            logger.info("\nScore in single game is \n{}:{}\n{}:{}",
                    player1.getName(), getScoreDescription(player1.getScore()),
                    player2.getName(), getScoreDescription(player2.getScore()));
        }
    }

    private boolean isGameFinished(Player player1, Player player2) {
        return (player1.getScore() >= MINIMUM_SCORE_TO_WIN - 1 && player2.getScore() >= MINIMUM_SCORE_TO_WIN - 1)
                || (player1.getScore() >= MINIMUM_SCORE_TO_WIN || player2.getScore() >= MINIMUM_SCORE_TO_WIN);
    }


    private void handleGameFinish(Player player1, Player player2) {
        int scoreDifference = player1.getScore() - player2.getScore();

        if (Math.abs(scoreDifference) >= 2) {
            Player winner = (player1.getScore() > player2.getScore()) ? player1 : player2;
            gameStatus.setGameFinished(true);
            winner.incrementGamesWon();
            logger.info("Game finished: {} scored 4 points and was ahead by 2 points", winner.getName());
            logger.info("Current score in set " + player1.getGamesWon() + " : " + player2.getGamesWon() + " " + winner.getName());

            gameSetCount++;
            resetScores(player1, player2);

        } else if (scoreDifference == 1 || scoreDifference == -1) {
            gameStatus.setAdvantage(true);
            logger.info("Advantage for {}!", (scoreDifference > 0) ? player1.getName() : player2.getName());
        } else if (player1.getScore() >= 3 && player2.getScore() >= 3) {
            gameStatus.setDeuce(true);
            logger.info("Deuce! One player needs to win two consecutive points to win the game.");
        }
    }

    private void resetScores(Player player1, Player player2) {
        player1.resetScore();
        player2.resetScore();
    }

    private String getScoreDescription(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            default -> "40";
        };
    }


    //TODO should add try catch and throw exceptions if invalid input or not integer
    public void initializeGame(Player player1, Player player2) {

        GameHandler gameHandler = new GameHandler(player1, player2);

        while (!gameHandler.getGameStatus().isGameFinished()) {

            logger.info("Please enter 1 to assign a point to {} and 2 to assign to point to {}", player1.getName(), player2.getName());
            int a = scanner.nextInt();

            if (a == 1) {
                player1.incrementScore();
            }
            if (a == 2) {
                player2.incrementScore();
            }

            gameHandler.startGame(player1, player2);
        }
    }
}