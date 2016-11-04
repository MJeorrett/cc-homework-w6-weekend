package card_game_lib;

public class Player extends Hand {

  private String name;

  public Player( String name ) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

}
