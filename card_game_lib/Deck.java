package card_game_lib;

public class Deck extends Hand {

  public Deck() {
    for ( Suit suit : Suit.values() ) {
      for ( Rank rank : Rank.values() ) {
        Card card = new Card( suit, rank );
        this.addCard( card );
      }
    }
  }
}
