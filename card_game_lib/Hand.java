package card_game_lib;

import java.util.*;

public class Hand {

  protected ArrayList<Card> cards;

  public Hand() {
    this.cards = new ArrayList<Card>();
  }

  public void addCard( Card card ) {
    this.cards.add( card );
  }

  public int cardCount() {
    return this.cards.size();
  }

  public boolean hasCard( Card testCard ) {

    for ( Card card : this.cards ) {
      if ( card.equals( testCard ) ) {
        return true;
      }
    }

    return false;
  }

  public void removeCard( Card card ) {

    for ( int i = 0; i < this.cards.size(); i++ ) {
      if ( this.cards.get( i ) == card ) {
        this.cards.remove( i );
      }
    }

  }

}
