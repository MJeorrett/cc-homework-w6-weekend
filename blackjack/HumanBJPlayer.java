package blackjack;

import card_game_lib.*;
import card_game_lib.user_interface.*;

public class HumanBJPlayer extends Player implements Dealable, BJPlayerable {

  private UserInterface ui;

  public HumanBJPlayer( String playerName, UserInterface ui ) {

    super( playerName );
    this.ui = ui;
  }

  public boolean isSticking() {

    return this.ui.getIsStickingForPlayer( this );
  }

}
