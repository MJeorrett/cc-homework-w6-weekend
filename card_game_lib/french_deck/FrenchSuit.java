package card_game_lib.french_deck;

import card_game_lib.*;

public enum FrenchSuit implements CardSuitValueable<FrenchSuit> {
  HEARTS("Hearts"),
  CLUBS("Clubs"),
  DIAMONDS("Diamonds"),
  SPADES("Spades");

  private String title;

  FrenchSuit( String title ) {
    this.title = title;
  }

  public String toDisStr() {
    return this.title;
  }
}
