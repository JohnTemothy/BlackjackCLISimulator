package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blackjack.models.Player;
import com.blackjack.models.PlayerList;
import com.blackjack.models.Shoe;

public class Game {

    private IOCli io;
    private Shoe shoe;
    private PlayerList playerList;

    public Game(IOCli io) {
        this.io = io;
    }

    /*
     * TODO: How can be insert any number of decks into the shoe?
     * TODO: How can we add any number of additional CPU players? Should there be a limit?
     */
    public void initGame() {
        shoe = new Shoe(2);
        playerList = new PlayerList();

        Scanner playerNameScanner = new Scanner(System.in);  // Allow for user input to change their username
        System.out.println("Enter username");
        String playerName = playerNameScanner.nextLine(); 

        playerList.addPlayer(new Player(playerName, false)); //Maybe make like a limit or checks incase username is too long or username is nothing
        playerList.addPlayer(new Player("Dealer", true));

        playerNameScanner.close();
    }

    public Boolean checkBlackjack() {

        //creates list of players with hand value > 21
        List<String> listOfBlackjacks = playerList.isBlackjackPlayerList();

        // if there is a single blackjack, print out winner
        // TODO: make a function for this so that you can call this multiple times, maybe make a loop or something if the player/dealer keeps drawing
        if (listOfBlackjacks.size() == 1) {
            System.out.println(listOfBlackjacks.get(0) + "wins!");
            return true;
        }


        // if there are more than one blackjacks, print out tie.
        // TODO: make it so this works for more than 2 players.
        else if (listOfBlackjacks.size() > 1) {
            System.out.println("tie!");
            return true;
        }

        return false;
    }


    public void startGame() {
        io.println("Welcome to Blackjack");
        initGame();

        // everything from here to the next comment is stuff i might move to a different function maybe

        shoe.shuffle();
        playerList.dealCards(shoe);

        if (checkBlackjack()) {
            return;
        }
        //

        io.println(shoe.toString());
    }

    /* Pseudocode
     * Dealer = D, Not dealer = ND
     * give every player 2 cards
     * Blackjack check for every player
     * ND: plays turn
     * Bust/Not Bust Check (if bust, D wins)
     * ND blackjack check 
     * 
     * Blackjack check for D
     * D: plays turn
     * Bust/Not Bust Check (if bust, ND wins)
     * ND blackjack check
     * 
     * if both player and dealer blackjack, tie
     * if ND > dealer, win
     * if dealer > ND, D win
     */



    
}
