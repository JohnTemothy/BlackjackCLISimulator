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
     * TODO: How can we add any number of additional CPU players? Should there be a limit?
     */
    public void initGame() {

        System.out.println("Enter number of players: ");               // Allow for user input to set number of players
        String numberOfPlayers = io.getInput();                          //TODO: make sure only numbers can be input from range 1-4
        int numberOfShoes = Integer.parseInt(numberOfPlayers);

        shoe = new Shoe(numberOfShoes);
        playerList = new PlayerList();

        for (int i = 1; i <= (numberOfShoes); i++) {                            //TODO: make a limit or checks incase username is too long or username is nothing
            System.out.println("Enter Player " + i + " username : ");                // Allow for user input to set their username
            String playerName = io.getInput();
            playerList.addPlayer(new Player(playerName, false));
        }
        
        playerList.addPlayer(new Player("Dealer", true));
    }





    public Boolean checkWinner() {                  //TODO: redo logic of checkWinner function so that you will only compare player's decks with dealer's deck

        List<Player> highestHandList = playerList.getHighestHandPlayers(playerList.getHighestHand());
        List<Player> winnerList = playerList.getHigherHandThanDealer(playerList.getDealerHand());
        List<Player> bustedList = playerList.isBustPlayerList();

        //creates list of players with hand value = 21
        List<String> listOf21s = playerList.is21List();

        /*if there is a single blackjack, print out the winner
        if (playerList.isBlackjackList().size() == 1) {
            System.out.println(playerList.isBlackjackList().get(0) + " wins with a blackjack!");
            return true;
        }*/

        //if everyone busted
        if (bustedList.size() == playerList.getPlayerList().size()){
            System.out.println("Everyone busted! Tie!");
        }

        //TODO: if only dealer busts
        if (bustedList.size() == 1 && (checkForDealer(playerList.isBustPlayerList()))){
            System.out.println("Dealer busted! Everyone wins!");
        }
        //TODO: if dealer and another person busts


        // iterate through the list of scores until you find the highest TODO: if dealer is the highest, only dealer wins. If multiple people are higher than the dealer, all of those people win

        //In the case that dealer wins
        if ((highestHandList.size() == 1) && checkForDealer(highestHandList)) {
            io.println( " Dealer wins!");
        }
        //In the case that there is a person with the same hand value as the dealer
        else if ((highestHandList.size() > 1) && checkForDealer(highestHandList)) {
            
            io.println("Tie between ");
            for (Player p : highestHandList) {
                //TODO: Make this all in one line
                io.println(p.getName().toString() + " ");
            }
            return true;
        }
        else if (winnerList.size() >= 1){
            for (Player p : winnerList) {
                io.println(p.getName().toString() + " wins with the cards " + highestHandList.get(0).getHand().toString());
            }
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


    //TODO: Make function that iterates through a list and returns true if dealer is present inside said list
    public boolean checkForDealer(List<Player> players) {
        for (Player p : players){
            if (p.getName().toLowerCase().equals("dealer")) {
                return true;
            }
        }
        return false;
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



    

