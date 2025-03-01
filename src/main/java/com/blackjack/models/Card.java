package com.blackjack.models;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(final Suit suit, final Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return String.format("[%s, %s]", suit.name(), rank.name());
    }
}
