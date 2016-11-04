package card_game_lib;

public class Card {

  private Suit suit;
  private Rank rank;

  public Card( Suit suit, Rank rank ) {
    this.suit = suit;
    this.rank = rank;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public Rank getRank() {
    return this.rank;
  }

  @Override
  public String toString() {
    return this.rank.toString() + " of " + this.suit.toString();
  }

}
