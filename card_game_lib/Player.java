package card_game_lib;

public abstract class Player extends Hand {

  private String name;

  public Player( String name ) {
    super();
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toDisStr() {
    String cardsString = super.toDisStr();
    return this.name + "'s cards:\n" + cardsString;
  }

}
