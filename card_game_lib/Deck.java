package card_game_lib;

import java.util.*;

public class Deck extends Hand {

  public Deck() {
    for ( Suit suit : Suit.values() ) {
      for ( Rank rank : Rank.values() ) {
        Card card = new Card( suit, rank );
        this.addCard( card );
      }
    }
  }

  public Card dealCard() {
    return this.cards.remove( 0 );
  }

  public void shuffle() {
    Collections.shuffle( this.cards );
  }
}
