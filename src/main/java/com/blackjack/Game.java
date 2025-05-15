package com.blackjack;

import com.blackjack.models.Player;
import com.blackjack.models.PlayerList;
import com.blackjack.models.Shoe;

public class Game {

    private IOCli io;
    private Shoe shoe;
    private PlayerList playerList;

    public Game(IOCli io) {
        this.io = io;
    }

    /*
     * TODO: How can be insert any number of decks into the shoe?
     * TODO: How can we add any number of additional CPU players? Should there be a limit?
     */
    public void initGame() {
        shoe = new Shoe(2);
        playerList = new PlayerList();
        playerList.addPlayer(new Player("Name", false));
        playerList.addPlayer(new Player("Dealer", true));
    }

    public void startGame() {
        io.println("Welcome to Blackjack");

        initGame();

        io.println(shoe.toString());
    }
}
