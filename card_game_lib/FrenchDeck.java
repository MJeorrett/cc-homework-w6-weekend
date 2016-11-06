package card_game_lib;

import java.util.ArrayList;

public class FrenchDeck extends Deck {

  public ArrayList<Card> setupCards() {

    ArrayList<Card> cards = new ArrayList<Card>();

    for ( Suit suit : Suit.values() ) {

      for ( Rank rank : Rank.values() ) {

        Card card = new Card( suit, rank );
        cards.add( card );
      }
    }

    return cards;
  }

}
