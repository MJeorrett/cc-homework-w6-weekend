package blackjack.tests;

import card_game_lib.*;
import card_game_lib.user_interface.*;
import blackjack.*;

public class BlackjackRunner {

  public static void main( String[] args ) {
    UserInterface userInterface = new UserInterface();
    Blackjack game = new Blackjack( userInterface );
  }

}
