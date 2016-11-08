package blackjack;

import card_game_lib.*;
import card_game_lib.french_deck.*;

import java.util.*;

public class Blackjack {
  
  public static final int TARGET_SCORE = 21;

  private BJUserInterface ui;
  private Dealer dealer;
  private ArrayList<BJPlayerable> players;

  public Blackjack( BJUserInterface ui, ArrayList<BJPlayerable> players ) {

    this.ui = ui;
    this.players = players;

    this.dealer = new Dealer( this.players, new FrenchDeck() );

  }

  // public ArrayList<Player> playRound() {
  //   this.dealer.dealCards( 2 );
  //
  //   for ( BlackjackPlayer player : this.players ) {
  //
  //     boolean playerIsBust = false;
  //     boolean playerIsSticking = player.isSticking();
  //
  //     while ( !playerIsBust && !playerIsSticking ) {
  //
  //       this.dealer.dealCardToPlayer( player );
  //
  //       playerIsBust = this.isBust( player );
  //       playerIsSticking = player.isSticking();
  //     }
  //   }
  //
  //   return Blackjack.winningPlayers( this.players );
  // }

  public static ArrayList<BJPlayerable> winningPlayers( ArrayList<BJPlayerable> players ) {

    ArrayList<BJPlayerable> winningPlayers = new ArrayList<BJPlayerable>();

    int winningScore = 0;
    BJPlayerable aPlayer;
    int aScore;

    for (int i = 0; i < players.size(); i++ ) {

      aPlayer = players.get( i );
      aScore = CardScorer.scoreCards( aPlayer.getCards() );

      if ( !Blackjack.isBust( aPlayer ) ) {

        if ( aScore == winningScore ) {
          winningPlayers.add( aPlayer );
        }

        if ( aScore > winningScore ) {
          winningPlayers.clear();
          winningScore = aScore;
          winningPlayers.add( aPlayer );
        }
      }
    }

    return winningPlayers;
  }

  public static boolean isBust( BJPlayerable player ) {

    int score = CardScorer.scoreCards( player.getCards() );

    if ( score > TARGET_SCORE ) {
      return true;
    }

    return false;
  }

}
