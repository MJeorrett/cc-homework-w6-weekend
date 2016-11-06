package card_game_lib;

import card_game_lib.french_deck.*;
import card_game_lib.user_interface.*;

public class Card implements Displayable {

  private CardSuitValueable suit;
  private CardSuitValueable rank;

  public Card( CardSuitValueable suit, CardSuitValueable rank ) {
    this.suit = suit;
    this.rank = rank;
  }

  public CardSuitValueable getSuit() {
    return this.suit;
  }

  public CardSuitValueable getRank() {
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
