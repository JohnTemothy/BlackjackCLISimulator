package com.blackjack.models;

public enum Suit {
    CLUBS("Clubs"),
    DIAMOND("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private String suitName;

    private Suit(final String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return this.suitName;
    }
}
