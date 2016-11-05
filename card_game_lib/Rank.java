package card_game_lib;

public enum Rank {
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

  Rank( String title ) {
    this.title = title;
  }

  public String toDisStr() {
    return this.title;
  }
}
