package blackjack;

import card_game_lib.*;
import card_game_lib.user_interface.*;

public class HumanBJPlayer extends Player implements BJPlayerable {

  private BJUserInterface ui;

  public HumanBJPlayer( String playerName, BJUserInterface ui ) {

    super( playerName );
    this.ui = ui;
  }

  public boolean isSticking() {

    return this.ui.playerIsSticking( this );
  }

}
