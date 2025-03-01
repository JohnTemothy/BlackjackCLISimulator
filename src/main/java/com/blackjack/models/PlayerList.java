package com.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private List<Player> players;

    public PlayerList() {
        players = new ArrayList<>();
    }

    public void addPlayer(final Player player) {
        players.add(player);
    }
    
    /*
     * How can we deal 2 cards to all players?
     */
    public void dealCards(final Shoe shoe) {
        // Hint: Use player.giveCard()
    }
}
