package blackjack;

import java.util.Scanner;
import java.util.ArrayList;
import card_game_lib.*;

public class Blackjack {

  public static final int MAX_NUMBER_PLAYERS = 10;

  private CardGame cardGame;

  public Blackjack() {
    String[] playerNames = this.getPlayerNames();
    this.cardGame = new CardGame( playerNames );
  }

  private String[] getPlayerNames() {
    Scanner inputScanner = new Scanner( System.in );
    System.out.print( String.format( "Enter the number of players:( 1 -> %d ): ", MAX_NUMBER_PLAYERS ) );
    int numberOfPlayers = inputScanner.nextInt();

    while ( numberOfPlayers < 1 || numberOfPlayers > MAX_NUMBER_PLAYERS ) {
      System.out.println( "Please enter a number between 0 and 10" );
      System.out.print( "Number of players: ");
      numberOfPlayers = inputScanner.nextInt();
    }

    ArrayList<String> playerNames = new ArrayList<String>();

    for ( int i = 1; i <= numberOfPlayers; i++ ) {
      System.out.print( String.format( "Enter the name for player %d: ", i ) );
      String name = inputScanner.next();
      playerNames.add( name );
    }

    System.out.println( "---" );
    System.out.println( "Ready to start with players: " );
    for ( String name : playerNames ) {
      System.out.println( "  " + name );
    }

    String[] result = new String[playerNames.size()];
    playerNames.toArray( result );

    return result;
  }

}
