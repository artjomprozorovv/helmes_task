package com.tennis.java;

import com.tennis.java.exception.FileNotCreatedException;
import com.tennis.java.handler.GameHandler;
import com.tennis.java.pojo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TennisGameDataWriter {

    private static final Logger logger = LoggerFactory.getLogger(GameHandler.class);
    private static final String RESULT_FORMAT = "Recorded Game Result: %s vs %s - Score: %d-%d%n";
    private final String TENNIS_GAMES_RECORDED_DATA_PATH = "src/main/resources/tennisGameData.txt";

    public void save(Player player1, Player player2) {
        String finalResult = formatGameResult(player1, player2);

        try {
            createFileIfNotExists();
            writeResultToFile(finalResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatGameResult(Player player1, Player player2) {
        return String.format(RESULT_FORMAT,
                player1.getName(), player2.getName(),
                player1.getScore(), player2.getScore());
    }

    private void writeResultToFile(String result) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TENNIS_GAMES_RECORDED_DATA_PATH, true))) {
            writer.write(result);
            System.out.println("Result saved to file: " + TENNIS_GAMES_RECORDED_DATA_PATH);
        }
    }

    private void createFileIfNotExists() throws IOException {
        File file = new File(TENNIS_GAMES_RECORDED_DATA_PATH);

        if (!file.exists()) {
            if (file.createNewFile()) {
                logger.info("File created: tennisGameData.txt at resources folder");
                System.out.println("File created: tennisGameData.txt");
            } else {
                throw new FileNotCreatedException("Unable to create file");
            }
        }
    }
}