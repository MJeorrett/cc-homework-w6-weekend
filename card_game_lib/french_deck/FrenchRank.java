package card_game_lib.french_deck;

public enum FrenchRank {
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("10"),
  JACK("Jack"),
  QUEEN("Queen"),
  KING("King"),
  ACE("Ace");

  private String title;

  FrenchRank( String title ) {
    this.title = title;
  }

  public String toDisStr() {
    return this.title;
  }
}
