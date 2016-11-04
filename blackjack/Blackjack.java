package blackjack;

import java.util.Scanner;
import card_game_lib.*;

public class Blackjack {

  public static final int MAX_NUMBER_PLAYERS = 10;

  public Blackjack() {
    Scanner inputScanner = new Scanner( System.in );
    System.out.print( "Enter the number of players:( 1 to 10 ): ");
    int numberOfPlayers = inputScanner.nextInt();

    while ( numberOfPlayers < 0 || numberOfPlayers > MAX_NUMBER_PLAYERS ) {
      System.out.println( "Please enter a number between 0 and 10" );
      System.out.print( "Number of players: ");
      numberOfPlayers = inputScanner.nextInt();
    }

    System.out.println( String.format( "Number of players selected: %d", numberOfPlayers ) );
  }

}
