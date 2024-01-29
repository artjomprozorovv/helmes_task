package com.tennis.java.service;


import com.tennis.java.exception.InvalidInputException;
import com.tennis.java.handler.GameHandler;
import com.tennis.java.handler.SetHandler;

import com.tennis.java.pojo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class TennisGameService {

    private static final Logger logger = LoggerFactory.getLogger(TennisGameService.class);
    private final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter a valid name";

    public void start() {
        logger.info("Welcome to Tennis Game - Advantage Set ---> Minimum 6 games");

        String player1Name = getPlayerName("Player 1");
        String player2Name = getPlayerName("Player 2");

        logger.info("Welcome {} and {} - you both registered for the game, good luck", player1Name, player2Name);

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        GameHandler gameHandler = new GameHandler(player1, player2);
        SetHandler setHandler = new SetHandler(gameHandler);
        setHandler.startSet(player1, player2);

        scanner.close();
    }

    private String getPlayerName(String playerNumber) {
        logger.info("Please enter {} name: ", playerNumber);
        String input = scanner.nextLine();
        return userInputChecker(input);
    }

    private String userInputChecker(String input) {
        try {
            while (!isInputContainsOnlyCharacters(input)) {
                logger.error(INVALID_INPUT_MESSAGE);
                input = scanner.nextLine();
            }
            return input;
        } catch (Exception e) {
            throw new InvalidInputException("Error while processing user input", e);
        }
    }

    private boolean isInputContainsOnlyCharacters(String s) {
        return s.matches("[a-zA-Z]+");
    }

}
