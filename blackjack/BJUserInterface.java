package blackjack;

import card_game_lib.*;
import card_game_lib.user_interface.*;

public class BJUserInterface extends UserInterface {

  public static boolean playerIsSticking( Player player ) {
    System.out.println( "Player " + player.getName() + " is sticking (they have no choice at the moment)" );
    return true;
  }

}
