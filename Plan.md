## Introduction


## Functional Requirements

### Program Start
The game shall support a single player
The game shall start by a configuration page

### Game Start
When the game starts, each player will recieve a set balance
Deck will be shuffled at the start of the game

### Round Start
Dealer will recieve two cards from the top of the deck, one face down and one face up.
Player will recieve a prompt asking for a bet amount ranging from 0 to the amount of remaining money the player has

Players shall play rounds in clockwise order. 
The dealer shall player his turn last.

### Play Round
Each player shall recieve 2 cards from the top of the deck
The player shall see only their own cards

### Card Drawing
If the card value total is less than 21, player shall recieve a prompt asking whether to "hit" or "stand"
When a player hits, they shall recieve one more card from the top of the deck. 
if the players card value total exceeds 21, the player "busts" and the quantity of money they bet is deducted from their balance
The player can continue "hitting" until they bust or stand
After the player stops, the dealer plays its turn.

### Card Calculation
Ace shall count as 1, 10, 11
When the first two cards are drawn, if they are an ACE and 10-Value card, the player gets Blackjack

### End of the Round
When the dealer busts, the players that have not bust will all recieve money equal to the sum they have bet.
When the dealer does not bust, non-bust players with a higher card value will receive their bet.
When the dealer does not bust, non-bust players with an equal card value get nothing.
When the dealer does not bust, non-bust players with a lower card value will lose their bet.

When the player has blackjack, they receive blackjack payout multiplier.

The game shall continue until the player reaches the winning amount or $0.


## Non-functional Requirements


## Constraints
The project must be written in Java
The game must be played through the CLI
