package blackjack.tests;

import card_game_lib.*;
import blackjack.*;

public class BlackjackRunner {

  public static void main( String[] args ) {
    UserInterface userInterface = new UserInterface();
    Blackjack game = new Blackjack( userInterface );
  }

}
