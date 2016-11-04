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

  public void addCard( Card card ) {
    this.hand.addCard( card );
  }

  public boolean hasCard( Card card ) {
    return this.hand.hasCard( card );
  }

  public void removeCard( Card card ) {
    this.hand.removeCard( card );
  }

}
