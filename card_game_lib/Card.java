package card_game_lib;

import card_game_lib.french_deck.*;
import card_game_lib.user_interface.*;

public class Card implements Displayable {

  private FrenchSuit suit;
  private FrenchRank rank;

  public Card( FrenchSuit suit, FrenchRank rank ) {
    this.suit = suit;
    this.rank = rank;
  }

  public FrenchSuit getSuit() {
    return this.suit;
  }

  public FrenchRank getRank() {
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
