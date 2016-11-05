package card_game_lib.tests;

import card_game_lib.*;

public class CardGameLibRunner {

  public static void main( String[] args ) {

    Deck deck = new Deck();
    deck.shuffle();

    for ( int i = 1; i <= 52; i++ ) {
      Card card = deck.dealCard();
      System.out.println( card.toString() );
    }
  }

}