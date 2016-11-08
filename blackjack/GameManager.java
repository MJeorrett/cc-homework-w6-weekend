package blackjack;

import card_game_lib.user_interface.*;

import java.util.*;

// responsible for setting up players and then creating a new game (intance of the Blackjack class)
public class GameManager {

  public static final int MAX_NUMBER_PLAYERS = 10;

  private BJUserInterface ui;
  private Blackjack game;

  public GameManager() {

    this.ui = new BJUserInterface();

    String[] playerNames = ui.getPlayerNames( 1, MAX_NUMBER_PLAYERS );
    ArrayList<BJPlayerable> players = new ArrayList<BJPlayerable>();

    AIBJPlayer player;

    for ( String playerName : playerNames ) {
      player = new AIBJPlayer( playerName );
      players.add( player );
    }

    System.out.println( "---" );
    System.out.println( "Ready to start with players: " );

    for ( String name : playerNames ) {
      System.out.println( "  " + name );
    }

    // Hand off to Blackjack
    this.game = new Blackjack( this.ui, players );

  }

}
