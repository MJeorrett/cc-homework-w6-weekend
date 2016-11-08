package blackjack;

import card_game_lib.*;
import card_game_lib.french_deck.*;

import java.util.*;

public class CardScorer {

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

  public static int scoreCards( ArrayList<Card> cards ) {

    int score = 0;
    int numberOfAces = 0;
    FrenchRank rank;

    for ( Card card : cards ) {

      rank = CardScorer.getFrenchRankForCard( card );

      if ( rank == FrenchRank.ACE ) {
        numberOfAces++;
      } else {
        score += CardScorer.scoreForRank( rank );
      }
    }

    if ( numberOfAces > 0 ) {

      score += numberOfAces - 1;

      if ( score <= Blackjack.TARGET_SCORE - ACE_HIGH_VALUE ) {
        score += ACE_HIGH_VALUE;
      } else {
        score += ACE_LOW_VALUE;
      }
    }

    return score;
  }

  public static int scoreCard( Card card ) {
    FrenchRank rank = CardScorer.getFrenchRankForCard( card );
    return CardScorer.rankValues.get( rank );
  }

  private static int scoreForRank( FrenchRank rank ) {
    return CardScorer.rankValues.get( rank );
  }

  private static FrenchRank getFrenchRankForCard( Card card ) {
    return (FrenchRank)card.getRank();
  }

}
