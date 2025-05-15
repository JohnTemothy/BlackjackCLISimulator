package com.blackjack.models;

import java.util.ArrayList;
import java.util.Collections;
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
        for (int i = 0; i < numDecks; i++) {

            for (Suit s: Suit.values()) {

                for (Rank r: Rank.values()){
                    cards.add(new Card(s, r));

                }
            }
        }
    }

    /*
     * TODO: Shuffle the deck, call this method after initializing the deck
     */
    public void shuffle() {
        int numberOfCards = cards.size();
        int numberOfLoops = (int)(Math.random() * (numberOfCards*2));
        for (int i = 0; i < numberOfLoops; i++) {
            int randomNumber1 = (int)(Math.random() * (numberOfCards + 1));
            int randomNumber2 = (int)(Math.random() * (numberOfCards + 1));
            try {
                Collections.swap(cards, randomNumber1,  randomNumber2);
                
            } finally {
                //just here so theres no error ig
            }
            
        }

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
