package blackjack;

import card_game_lib.*;
import card_game_lib.french_deck.*;
import card_game_lib.user_interface.*;

import java.util.*;

public class Blackjack {

  private UIable ui;
  private Dealer dealer;
  private ArrayList<BlackjackPlayer> players;

  public static final int MAX_NUMBER_PLAYERS = 10;
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

  public Blackjack( UIable ui ) {

    this.ui = ui;

    String[] playerNames = ui.getPlayerNames( 1, MAX_NUMBER_PLAYERS );
    this.players = new ArrayList<BlackjackPlayer>();

    BlackjackPlayer player;

    for ( String playerName : playerNames ) {
      player = new BlackjackPlayer( playerName );
      this.players.add( player );
    }

    this.dealer = new Dealer( this.players, new FrenchDeck() );

    System.out.println( "---" );
    System.out.println( "Ready to start with players: " );

    for ( String name : playerNames ) {
      System.out.println( "  " + name );
    }

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
  //       playerIsBust = this.isBust( player.getHand() );
  //       playerIsSticking = player.isSticking();
  //     }
  //   }
  //
  //   return Blackjack.winningPlayers( this.players );
  // }

  public static ArrayList<BlackjackPlayer> winningPlayers( ArrayList<BlackjackPlayer> players ) {

    ArrayList<BlackjackPlayer> winningPlayers = new ArrayList<BlackjackPlayer>();

    int winningScore = 0;
    BlackjackPlayer aPlayer;
    int aScore;

    for (int i = 0; i < players.size(); i++ ) {

      aPlayer = players.get( i );
      aScore = Blackjack.scoreHand( aPlayer.getHand() );

      if ( !Blackjack.isBust( aPlayer.getHand() ) ) {

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

  public static int scoreHand( Hand hand ) {

    int score = 0;
    int numberOfAces = 0;
    FrenchRank rank;

    for ( Card card : hand.getCards() ) {

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

  public static boolean isBust( Hand hand ) {

    if ( Blackjack.scoreHand( hand ) > TARGET_SCORE ) {
      return true;
    }

    return false;
  }

}
