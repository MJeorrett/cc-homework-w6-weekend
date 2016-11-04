package card_game_lib;

import java.util.*;

public class Hand {

  ArrayList<Card> cards;

  public Hand() {
    this.cards = new ArrayList<Card>();
  }

  public void addCard( Card card ) {
    this.cards.add( card );
  }

  public boolean hasCard( Card testCard ) {

    for ( Card card : this.cards ) {
      if ( card.equals( testCard ) ) {
        return true;
      }
    }

    return false;
  }

}
