package com.tennis.java.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Player {

    private final String name;
    private int score;
    private int gamesWon;

    public void incrementScore(){
        score ++;
    }

    public void incrementGamesWon(){
        gamesWon++;
    }

    public void resetScore(){
        score = 0;
    }
}
