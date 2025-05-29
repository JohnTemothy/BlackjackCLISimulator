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

        if (2 * playerCount <= noCards) {
            throw new IllegalStateException("Not enough cards to deal");
        }

        for (Player p : players) {
            p.giveCard(shoe.draw());
            p.giveCard(shoe.draw());
        }
    }

    /*
     * checks if player has gotten a blackjack (hand value = 21)
     */
    public boolean isBlackjackPlayerList(Player player) {
        return player.isBlackjack();
    }

    /*
     * checks if players hand has exceeded value of 21
     */
    public boolean isBustPlayerList(Player player) {
        return player.isBust();
    }
}
