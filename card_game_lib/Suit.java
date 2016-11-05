package card_game_lib;

public enum Suit {
  HEARTS("Hearts"),
  CLUBS("Clubs"),
  DIAMONDS("Diamonds"),
  SPADES("Spades");

  private String title;

  Suit( String title ) {
    this.title = title;
  }

  public String toDisStr() {
    return this.title;
  }
}
