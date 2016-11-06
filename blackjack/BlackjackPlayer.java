package blackjack;

import card_game_lib.*;

public class BlackjackPlayer extends Player implements Dealable {

  public BlackjackPlayer( String playerName ) {
    super( playerName );
  }

  public boolean isSticking() {

    return true;
  }

}
