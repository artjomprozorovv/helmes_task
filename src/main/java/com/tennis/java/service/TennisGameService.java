package com.tennis.java.service;


import com.tennis.java.handler.GameHandler;
import com.tennis.java.handler.SetHandler;

import com.tennis.java.pojo.Player;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;


public class TennisGameService {

    private final static Logger logger = LoggerFactory.getLogger(GameHandler.class);
    private final Scanner scanner = new Scanner(System.in);

    public void startSet() {
        logger.info("Welcome to Tennis Game - Advantage Set ---> Minimum 6 games");
        logger.info("Please enter Player 1 name: ");
        String player1Name = scanner.nextLine();

        logger.info("Please enter Player 2 name: ");
        String player2Name = scanner.nextLine();
        logger.info("Welcome {} and {} - you both registered for the game, good luck", player1Name, player2Name);

        SetHandler setHandler = new SetHandler();
        setHandler.startSet(new Player(player1Name),new Player(player2Name));
        }

}
