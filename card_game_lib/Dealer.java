package card_game_lib;

import blackjack.*;

import java.util.*;

public class Dealer {

  private ArrayList<? extends Playerable> players;
  private Deck deck;

  public Dealer( ArrayList<? extends Playerable> players, Deck deck ) {

    this.deck = deck;
    this.players = players;
  }

  public int numberOfPlayers() {
    return players.size();
  }

  public void dealRound() {
    for ( Playerable player : this.players ) {
      this.dealCardToPlayer( player );
    }
  }

  public void dealRounds( int number ) {
    for ( int i = 0; i < number; i++ ) {
      this.dealRound();
    }
  }

  public void dealCardToPlayer( Playerable player ) {
    player.addCard( this.deck.dealCard() );
  }

}
