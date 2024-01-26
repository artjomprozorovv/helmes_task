package com.tennis.java.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GameStatus {
    private boolean isDeuce;
    private boolean isAdvantage;
    private boolean isGameFinished;
}
