package com.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private final List<Player> players;

    public PlayerList() {
        players = new ArrayList<>();
    }

    public void addPlayer(final Player player) {
        players.add(player);
    }

    /**
     * Deals to 2 cards to all players.
     *
     * Iterates through the player list, giving 2 cards to each.
     *
     * @param shoe The deck of cards to deal from
     * @throws IllegalStateException if not enough cards to deal
     */
    public void dealCards(final Shoe shoe) {
        int noCards = shoe.getNoCards();
        int playerCount = players.size();

        if (2 * playerCount > noCards) {
            throw new IllegalStateException("Not enough cards to deal");
        }

        for (Player p : players) {
            p.giveCard(shoe.draw());
            p.giveCard(shoe.draw());
        }
    }

    /**
     * Draws card for a given player
     *
     * gives one card to a given player.
     *
     * @param shoe The deck of cards to deal from
     * @throws IllegalStateException if not enough cards to deal
     */
    public void drawCard(final Shoe shoe, Player player) {
        int noCards = shoe.getNoCards();

        if (noCards < 1) {
            throw new IllegalStateException("Not enough cards to deal");
        }
        Card drawnCard = shoe.draw();
        System.out.println(player.getName() + " drew " + drawnCard.toString());
        player.giveCard(drawnCard);
    }

    /**
     * Iterates through the player list, returning the highest hand value that is not a bust.
     */
    public int getHighestHand() {
        int highestHandValue = 0;


        for (Player p : players) {
            if ((p.getHandValue() > highestHandValue) && (!p.isBust())) {
                highestHandValue = p.getHandValue();
            }
        }

        return highestHandValue;
    }

    /**
     * Iterates through the player list, returning the player with highest hand value that is not a bust.
     */
    public List<Player> getHighestHandPlayers(int highestHandValue) {
        List<Player> winningPlayers;
        winningPlayers = new ArrayList<>();

        for (Player p : players) {
            if (p.getHandValue() == highestHandValue){
                winningPlayers.add(p);
            }
        }

        return winningPlayers;
    }

    

    /*
     * creates and returns list of players who's hands equal the value of 21 
     */
    public List<String> is21List() {
        List<String> winners = new ArrayList<String>();
        for (Player p : players) {
            if (p.is21()) {
                winners.add(p.getName());
            }
        }
        return winners;
    }

    /*
     * creates and returns list of players who's hands are a blackjack
     */
    public List<String> isBlackjackList() {
        List<String> blackjackWinners = new ArrayList<String>();
        for (Player p : players) {
            if (p.is21() && (p.getHand().size() == 2)) {
                blackjackWinners.add(p.getName());
            }
        }
        return blackjackWinners;
    }

    /*
     * creates and returns list of players who's hands exceed value of 21 
     */
    public List<String> isBustPlayerList() {
        List<String> bustedPlayers = new ArrayList<String>();
        for (Player p : players) {
            if (p.isBust()) {
                bustedPlayers.add(p.getName());
            }
        }
        return bustedPlayers;
    }

    public List<Player> getPlayerList() {
        return players;
    }


    
}
