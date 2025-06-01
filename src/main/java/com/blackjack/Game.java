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
        //io.println(shoe.toString());
        

        shoe.shuffle();
        playerList.dealCards(shoe);

        if (checkBlackjack()) {
            return;
        }

        for (Player p : playerList.getPlayerList()) {
            playerTurn(p);
        }

        
        
       
        // 

    }

    // TODO: make function that accepts input of player. if cpu == true, play turn for them. if cpu == false, prompt user to hit or stand

    public void playerTurn(Player player) {
        
        // if the player is a cpu, the player will continue drawing cards until they bust or win.
        if (player.isCpu()) {
            while ((player.getHandValue() < playerList.getHighestHand()) ) {
                playerList.drawCard(shoe, player);
                if (checkBlackjack()) {
                    return;
                }
            }
        }
        // if the player is not a cpu, prompt the user to hit or stand.
        else {
            io.println(player.getHand().toString());
            Scanner hitOrStandScanner = new Scanner(System.in);
            System.out.println("Hit or Stand");
            String hitOrStand = hitOrStandScanner.nextLine(); 
            hitOrStandScanner.close();

            while ((player.isBust() != true)) {
                if (hitOrStand.toLowerCase() == "hit")
                {
                    player.giveCard(shoe.draw());
                    if (checkBlackjack()) {
                    return;
                    }
                }
                else if (hitOrStand.toLowerCase() == "stand") {
                    return;
                }
                else {
                    System.out.println("Error, must input Hit or Stand");
                    return;
                }
            }
        }
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
