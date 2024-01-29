package com.tennis.java;

import com.tennis.java.service.TennisGameService;


public class TennisGameApp {

    public static void main(String[] args) {

        TennisGameService tennisGameService = new TennisGameService();

        tennisGameService.start();
    }
}
