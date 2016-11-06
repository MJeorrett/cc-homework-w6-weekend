package blackjack;

import card_game_lib.user_interface.*;

import java.util.*;

public class GameManager {

  public static final int MAX_NUMBER_PLAYERS = 10;

  private UserInterface ui;
  private Blackjack game;

  public GameManager() {

    this.ui = new UserInterface();

    String[] playerNames = ui.getPlayerNames( 1, MAX_NUMBER_PLAYERS );
    ArrayList<BlackjackPlayer> players = new ArrayList<BlackjackPlayer>();

    BlackjackPlayer player;

    for ( String playerName : playerNames ) {
      player = new BlackjackPlayer( playerName );
      players.add( player );
    }

    this.game = new Blackjack( this, players );

    System.out.println( "---" );
    System.out.println( "Ready to start with players: " );

    for ( String name : playerNames ) {
      System.out.println( "  " + name );
    }

  }

}
