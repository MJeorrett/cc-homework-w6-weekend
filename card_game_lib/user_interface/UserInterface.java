package card_game_lib.user_interface;

import java.util.*;

public class UserInterface implements Interfaceable {

  public UserInterface() {

  }

  public String[] getPlayerNames( int min, int max ) {
    Scanner inputScanner = new Scanner( System.in );
    System.out.print( String.format( "Enter the number of players:( %d -> %d ): ", min, max ) );
    int numberOfPlayers = inputScanner.nextInt();

    while ( numberOfPlayers < min || numberOfPlayers > max ) {
      System.out.println( String.format( "Please enter a number between %d and %d", min, max ) );
      System.out.print( "Number of players: ");
      numberOfPlayers = inputScanner.nextInt();
    }

    ArrayList<String> playerNames = new ArrayList<String>();

    for ( int i = 1; i <= numberOfPlayers; i++ ) {
      System.out.print( String.format( "Enter the name for player %d: ", i ) );
      String name = inputScanner.next();
      playerNames.add( name );
    }

    String[] result = new String[playerNames.size()];
    playerNames.toArray( result );

    return result;
  }

}