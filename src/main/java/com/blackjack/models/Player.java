package com.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> hand;
    private String name;
    private boolean cpu;

    public Player(final String name, final boolean cpu) {
        this(name, cpu, new ArrayList<>());
    }

    public Player(final String name, final boolean cpu, final List<Card> hand) {
        this.name = name;
        this.cpu = cpu;
        this.hand = hand;
    }

    /**
     * Checks if the player's hand has exceeded value of 21 (bust).
     *
     * @return True if bust
     */
    public boolean isBust() {
        int valueCount = 0;
        for (Card c : hand) {
            valueCount = valueCount + c.getRank().getValue();
        }
        return valueCount > 21;
    }

    /**
     * Checks if the player's hand has value of 21 (blackjack).
     *
     * @return True if blackjack
     */
     public boolean is21() {
        int valueCount = 0;
        for (Card c : hand) {
            valueCount = valueCount + c.getRank().getValue();
        }
        return valueCount == 21;
    }

    /**
     * @return value of player's hand
     */
     public int getHandValue() {
        int valueCount = 0;
        for (Card c : hand) {
            valueCount = valueCount + c.getRank().getValue();
        }
        return valueCount;
    }
    

    
    /*
     * Adds a given card to each player's hand
     * 
     * @param card item of class "Card" to be added to player's hand (list of type card) 
     */
    public void giveCard(Card card) {
        hand.add(card);
    }

    /*
     * Removes all items of type "Card" from the player's hand (list of type card)
     */
    public void clearHand() {
        hand.clear();
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
