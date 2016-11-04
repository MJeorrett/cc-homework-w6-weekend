package card_game_lib;

import java.util.*;

public class CardGame {

  private Player[] players;
  private Deck deck;
  private int numberOfPlayers;

  public CardGame( String[] playerNames ) {

    this.deck = new Deck();
    this.deck.shuffle();

    this.numberOfPlayers = playerNames.length;
    this.players = new Player[numberOfPlayers];

    for ( int i = 0; i < numberOfPlayers; i++ ) {
      Player player = new Player( playerNames[i] );
      this.players[i] = player;
    }
  }

  public int numberOfPlayers() {
    return this.numberOfPlayers;
  }

  public Player[] getPlayers() {
    return this.players;
  }

  public void dealRound() {
    for ( Player player : this.players ) {
      player.addCard( this.deck.dealCard() );
    }
  }

  public void dealCardToPlayer( Player player ) {
    player.addCard( this.deck.dealCard() );
  }

  public static String[] getNames( int min, int max ) {
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
