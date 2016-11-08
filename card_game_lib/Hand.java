package card_game_lib;

import card_game_lib.user_interface.*;

import java.util.ArrayList;

public class Hand implements Displayable {

  protected ArrayList<Card> cards;

  public Hand() {
    this.cards = new ArrayList<Card>();
  }

  public void addCard( Card card ) {
    this.cards.add( card );
  }

  public int cardsRemaining() {
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

  public boolean removeCard( Card card ) {

    for ( int i = 0; i < this.cards.size(); i++ ) {
      if ( this.cards.get( i ) == card ) {
        this.cards.remove( i );
        return true;
      }
    }

    return false;
  }

  public ArrayList<Card> getCards() {
    return this.cards;
  }

  public String toDisStr() {
    String displayString = "";

    for ( Card card : this.cards ) {
      displayString += card.toDisStr() + "\n";
    }

    return displayString;
  }

}
