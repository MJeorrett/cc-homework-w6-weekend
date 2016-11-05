package blackjack;

import java.util.*;
import card_game_lib.*;
import card_game_lib.user_interface.*;

public class Blackjack extends CardGame {

  private Interfaceable userInterface;

  public static final int MAX_NUMBER_PLAYERS = 10;

  private static final Map<Rank, Integer> rankValues;
  static {
    rankValues = new EnumMap<Rank, Integer>( Rank.class );
    rankValues.put( Rank.TWO, new Integer( 2 ) );
    rankValues.put( Rank.THREE, new Integer( 3 ) );
    rankValues.put( Rank.FOUR, new Integer( 4 ) );
    rankValues.put( Rank.FIVE, new Integer( 5 ) );
    rankValues.put( Rank.SIX, new Integer( 6 ) );
    rankValues.put( Rank.SEVEN, new Integer( 7 ) );
    rankValues.put( Rank.EIGHT, new Integer( 8 ) );
    rankValues.put( Rank.NINE, new Integer( 9 ) );
    rankValues.put( Rank.TEN, new Integer( 10 ) );
    rankValues.put( Rank.JACK, new Integer( 10 ) );
    rankValues.put( Rank.QUEEN, new Integer( 10 ) );
    rankValues.put( Rank.KING, new Integer( 10 ) );
  }

  public Blackjack( Interfaceable userInterface ) {

    this.userInterface = userInterface;

    String[] playerNames = userInterface.getPlayerNames( 1, MAX_NUMBER_PLAYERS );
    this.initializeGame( playerNames );

    System.out.println( "---" );
    System.out.println( "Ready to start with players: " );

    for ( String name : playerNames ) {
      System.out.println( "  " + name );
    }

  }

  public static int scoreHand( Hand hand ) {

    int score = 0;
    Rank rank;

    for ( Card card : hand.getCards() ) {
      rank = card.getRank();
      score += rankValues.get( rank );
    }

    return score;
  }

}
