package com.blackjack.models;

import java.util.List;

public class Player {
    private List<Card> hand;
    private String name;
    private boolean cpu;
    
    public Player(final String name, final boolean cpu) {
        this.name = name;
        this.cpu = cpu;
    }

    /*
     * TODO: How can we check if a player is bust?
     */
    public boolean isBust() {
        return false;
    }

    /*
     * TODO: Write a method to add a given card to each player's hand
     */
    public void giveCard(Card card) {
        
    }

    /*
     * TODO: Write a method to clear a player's hand (e.g. at round end)
     */
    public void clearHand() {

    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCpu() {
        return cpu;
    }

    public void setCpu(boolean cpu) {
        this.cpu = cpu;
    }
}
