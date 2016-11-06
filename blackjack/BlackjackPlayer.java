package blackjack;

import card_game_lib.*;

public class BlackjackPlayer extends Player {

  enum Action {
    STICK,
    TWIST
  }

  public BlackjackPlayer( String playerName ) {
    super( playerName );
  }

  public Action getAction() {

    return Action.STICK;
  }

}