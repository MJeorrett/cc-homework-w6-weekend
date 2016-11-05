package card_game_lib;

import card_game_lib.user_interface.*;

public class Card implements Displayable {

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
  public String toDisStr() {
    return this.rank.toDisStr() + " of " + this.suit.toDisStr();
  }

  public boolean equals( Card otherCard ) {
    boolean suitsMatch = this.suit == otherCard.getSuit();
    boolean ranksMatch = this.rank == otherCard.getRank();
    return suitsMatch && ranksMatch;
  }

}
