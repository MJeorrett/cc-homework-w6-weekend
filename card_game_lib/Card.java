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

  public boolean equals( Card otherCard ) {
    boolean suitsMatch = this.suit == otherCard.getSuit();
    boolean ranksMatch = this.rank == otherCard.getRank();
    return suitsMatch && ranksMatch;
  }

}
