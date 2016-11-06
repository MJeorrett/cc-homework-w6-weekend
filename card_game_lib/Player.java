package card_game_lib;

public class Player extends Hand {

  private String name;

  public Player( String name ) {
    super();
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public Hand getHand() {
    return (Hand)this;
  }

  @Override
  public String toDisStr() {
    String cardsString = super.toDisStr();
    return this.name + "'s cards:\n" + cardsString;
  }

}
