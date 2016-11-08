package blackjack;

import card_game_lib.*;
import card_game_lib.french_deck.*;

import java.util.*;

public class Blackjack {

  private BJUserInterface ui;
  private Dealer dealer;
  private ArrayList<BJPlayerable> players;

  public static final int TARGET_SCORE = 21;
  public static final int ACE_HIGH_VALUE = 11;
  public static final int ACE_LOW_VALUE = 1;

  private static final Map<FrenchRank, Integer> rankValues;
  static {
    rankValues = new EnumMap<FrenchRank, Integer>( FrenchRank.class );
    rankValues.put( FrenchRank.TWO, new Integer( 2 ) );
    rankValues.put( FrenchRank.THREE, new Integer( 3 ) );
    rankValues.put( FrenchRank.FOUR, new Integer( 4 ) );
    rankValues.put( FrenchRank.FIVE, new Integer( 5 ) );
    rankValues.put( FrenchRank.SIX, new Integer( 6 ) );
    rankValues.put( FrenchRank.SEVEN, new Integer( 7 ) );
    rankValues.put( FrenchRank.EIGHT, new Integer( 8 ) );
    rankValues.put( FrenchRank.NINE, new Integer( 9 ) );
    rankValues.put( FrenchRank.TEN, new Integer( 10 ) );
    rankValues.put( FrenchRank.JACK, new Integer( 10 ) );
    rankValues.put( FrenchRank.QUEEN, new Integer( 10 ) );
    rankValues.put( FrenchRank.KING, new Integer( 10 ) );
  }

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
      aScore = Blackjack.scorePlayer( aPlayer );

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

  public static int scorePlayer( BJPlayerable player ) {

    int score = 0;
    int numberOfAces = 0;
    FrenchRank rank;

    for ( Card card : player.getCards() ) {

      rank = (FrenchRank)card.getRank();

      if ( rank == FrenchRank.ACE ) {
        numberOfAces++;
      } else {
        score += rankValues.get( rank );
      }
    }

    if ( numberOfAces > 0 ) {

      score += numberOfAces - 1;

      if ( score <= TARGET_SCORE - ACE_HIGH_VALUE ) {
        score += ACE_HIGH_VALUE;
      } else {
        score += ACE_LOW_VALUE;
      }
    }

    return score;
  }

  public static boolean isBust( BJPlayerable player ) {

    if ( Blackjack.scorePlayer( player ) > TARGET_SCORE ) {
      return true;
    }

    return false;
  }

}
