package com.blackjack.models;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        ListIterator<Player> playerIterator = players.listIterator();


        for (Player p: players) {
            //i cant find what the deck value is
            if (Shoe.size() >= 2) {
                p.hand.giveCard();
                p.hand.giveCard();
            }
 ....
        }
    }
}
