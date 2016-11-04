package blackjack;

import java.util.Scanner;
import java.util.ArrayList;
import card_game_lib.*;

public class Blackjack {

  public static final int MAX_NUMBER_PLAYERS = 10;

  private CardGame cardGame;

  public Blackjack() {
    
    String[] playerNames = CardGame.getNames( 0, MAX_NUMBER_PLAYERS );
    this.cardGame = new CardGame( playerNames );

    System.out.println( "---" );
    System.out.println( "Ready to start with players: " );

    for ( String name : playerNames ) {
      System.out.println( "  " + name );
    }

  }

}
