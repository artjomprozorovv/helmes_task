package com.tennis.java.handler;

import com.tennis.java.pojo.Player;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SetHandler {

    private final GameHandler gameHandler;

    private boolean isSetFinished(Player player1,Player player2) {
        return (player1.getGamesWon() >= 6 || player2.getGamesWon() >= 6)
                && Math.abs(player1.getGamesWon() - player2.getGamesWon()) >= 2;

    }

    public void startSet(Player player1,Player player2){
        while (!isSetFinished(player1,player2)) {
            gameHandler.initializeGame(player1,player2);
        }
    }
}
