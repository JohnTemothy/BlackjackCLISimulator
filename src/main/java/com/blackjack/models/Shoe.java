package com.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {

    private final List<Card> cards;

    /*
     * TODO: How can we set up the shoe with any number of decks?
     * 
     * Remember that each deck has 4 Suits * 13 cards
     */
    public Shoe(final int numDecks) {
        cards = new ArrayList<>();
        for (int i = 0; i < numDecks; i++) {

            for (Suit s : Suit.values()) {

                for (Rank r : Rank.values()) {
                    cards.add(new Card(s, r));

                }
            }
        }
    }

    /*
     * TODO: Shuffle the deck, call this method after initializing the deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /*
     * TODO: How can we draw the top card of the deck?
     * This involves removing it and returning it
     */
    public Card draw() {
        return cards.remove(0);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        cards.stream().forEach(card -> builder.append(card).append("\n"));
        return builder.toString();
    }

    public int getNoCards() {
        return cards.size();
    }
}
