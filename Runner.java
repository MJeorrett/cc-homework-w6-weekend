import card_game_lib.*;

public class Runner {

  public static void main( String[] args ) {

    Deck deck = new Deck();

    for ( int i = 1; i <= 52; i++ ) {
      Card card = deck.dealCard();
      System.out.println( card.toString() );
    }
  }

}
