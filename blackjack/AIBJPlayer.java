package blackjack;

import card_game_lib.*;

public class AIBJPlayer extends Player implements BJPlayerable {

  public AIBJPlayer( String playerName ) {
    super( playerName );
  }

  public boolean isSticking() {

    return true;
  }

}
