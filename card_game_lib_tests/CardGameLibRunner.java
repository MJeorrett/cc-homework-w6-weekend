package card_game_lib.tests;

import card_game_lib.*;
import card_game_lib.french_deck.*;

public class CardGameLibRunner {

  public static void main( String[] args ) throws DeckEmptyException {

    Deck deck = new FrenchDeck();
    deck.shuffle();

    for ( int i = 1; i <= 52; i++ ) {

      Card card = deck.dealCard();

      System.out.println( card.toString() );
    }
  }

}
