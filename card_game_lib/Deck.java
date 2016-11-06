package card_game_lib;

import java.util.*;

public abstract class Deck extends Hand {

  public Deck() {
    super();
    this.cards = this.setupCards();
  }

  public abstract ArrayList<Card> setupCards();

  public Card dealCard() {
    return this.cards.remove( 0 );
  }

  public void shuffle() {
    Collections.shuffle( this.cards );
  }

}
