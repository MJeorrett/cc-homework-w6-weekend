package card_game_lib;

public class Player {

  private String name;
  private Hand hand;

  public Player( String name ) {
    this.name = name;
    this.hand = new Hand();
  }

  public String getName() {
    return this.name;
  }

  public void takeCard( Card card ) {
    this.hand.addCard( card );
  }

  public boolean hasCard( Card card ) {
    return this.hand.hasCard( card );
  }

}