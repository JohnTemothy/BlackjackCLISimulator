package com.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Shoe {
    private List<Card> cards;
    
    /*
     * TODO: How can we set up the shoe with any number of decks?
     * 
     * Remember that each deck has 4 Suits * 13 cards
     */
    public Shoe(final int numDecks) {
        cards = new ArrayList<>();

        cards.add(new Card(Suit.CLUBS, Rank.TWO));
    }

    /*
     * TODO: Shuffle the deck, call this method after initializing the deck
     */
    public void shuffle() {

    }

    /*
     * TODO: How can we draw the top card of the deck?
     * This involves removing it and returning it
     */
    public Card draw() {
        return null;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        cards.stream().forEach(card -> builder.append(card + "\n"));
        return builder.toString();
    }
}
