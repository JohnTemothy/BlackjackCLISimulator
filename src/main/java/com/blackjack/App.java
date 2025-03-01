package com.blackjack;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Game game = new Game(new IOCli(new Scanner(System.in,
                "UTF-8"), System.out));
        game.startGame();
    }
}
