package com.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blackjack.models.Card;
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

        System.out.println("Enter username");               // Allow for user input to set their username
        String playerName = io.getInput();

        playerList.addPlayer(new Player(playerName, false)); //Maybe make like a limit or checks incase username is too long or username is nothing
        playerList.addPlayer(new Player("Dealer", true));
    }

    public Boolean checkWinner() {

        //creates list of players with hand value > 21
        List<String> listOf21s = playerList.is21List();

        //if there is a single blackjack, print out the winner
        if (playerList.isBlackjackList().size() == 1) {
            System.out.println(playerList.isBlackjackList().get(0) + " wins with a blackjack!");
            return true;
        }

        // if there is a single 21, print out winner
        if (listOf21s.size() == 1) {
            System.out.println(listOf21s.get(0) + " wins!");
            return true;
        }

        //if everyone busted
        if (playerList.isBustPlayerList().size() == playerList.getPlayerList().size()){
            System.out.println("Everyone busted! Tie!");
        }

        // iterate through the list of scores until you find the highest
        List<Player> winnerList = playerList.getHighestHandPlayers(playerList.getHighestHand());
        if (winnerList.size() > 1) {
            io.println("Tie!");
            return true;
        }
        else if (winnerList.size() == 1){
            io.println(winnerList.get(0).getName().toString() + " wins with the cards " + winnerList.get(0).getHand().toString());
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


        for (Player p : playerList.getPlayerList()) {
            playerTurn(p);
        }
        checkWinner();
        
        
       

    }

    // TODO: make function that accepts input of player. if cpu == true, play turn for them. if cpu == false, prompt user to hit or stand

    public void playerTurn(Player player) {
        
        // if the player is a cpu, the player will continue drawing cards until they bust or win.

        if (player.isCpu()) {

            io.println(player.getName() + "'s turn!");

            // prints out cpu's hand
            io.println(player.getName() + "'s hand is: " + player.getHand().toString());

            while ((player.getHandValue() < playerList.getHighestHand()) ) {
                playerList.drawCard(shoe, player);
            }
            if (player.isBust()){
                System.err.println( player.getName() + " busts!");
            }
        }

        // if the player is not a cpu, prompt the user to hit or stand.
        else {
            io.println(player.getName() + "'s turn!");
            io.println(player.getName() + "'s hand is: " + player.getHand().toString());

            //if player's hand value is 21, end the function
            if (player.is21()){
                return;
            }

            

            // Loops until player either busts or is satisfied with their card total 
            while(!player.isBust()){
                System.out.println("Hit or Stand");
                String hitOrStand = io.getInput().trim();
                if (hitOrStand.toLowerCase().equals("hit")){
                    playerList.drawCard(shoe, player);
                }
                else if (hitOrStand.toLowerCase().equals("stand")){
                    return;
                }
                else {
                System.out.println("Error, must input Hit or Stand");
                }
            }
            if (player.isBust()){
                System.out.println( player.getName() + " busts!");
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



    

