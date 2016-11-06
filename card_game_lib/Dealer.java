package card_game_lib;

import blackjack.*;

import java.util.*;

public class Dealer {

  private ArrayList<? extends Dealable> players;
  private Deck deck;

  public Dealer( ArrayList<? extends Dealable> players, Deck deck ) {

    this.deck = deck;
    this.players = players;
  }

  public int numberOfPlayers() {
    return players.size();
  }

  public void dealCardToPlayer( Dealable player ) throws DeckEmptyException {

    player.addCard( this.deck.dealCard() );
  }

  public void dealRound() throws DeckEmptyException {
    for ( Dealable player : this.players ) {
      this.dealCardToPlayer( player );
    }
  }

  public void dealRounds( int number ) throws DeckEmptyException {
    for ( int i = 0; i < number; i++ ) {
      this.dealRound();
    }
  }

}
