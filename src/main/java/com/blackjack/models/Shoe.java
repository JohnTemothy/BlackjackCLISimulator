package com.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {

    private final List<Card> cards;

    /*
     * Accepts number of decks (numDecks) and adds required cards to the ArrayList cards
     *
     * @param numDecks the number of decks to be added to the cards list
     * 
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
     * rearranges cards list randomly
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /*
     * removes and returns first element of cards list
     *
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
