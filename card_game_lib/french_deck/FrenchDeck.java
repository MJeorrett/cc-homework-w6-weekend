package card_game_lib.french_deck;

import card_game_lib.*;

import java.util.ArrayList;

public class FrenchDeck extends Deck {

  public ArrayList<Card> setupCards() {

    ArrayList<Card> cards = new ArrayList<Card>();

    for ( FrenchSuit suit : FrenchSuit.values() ) {
      for ( FrenchRank rank : FrenchRank.values() ) {
        Card card = new Card( suit, rank );
        cards.add( card );
      }
    }

    return cards;
  }

}
