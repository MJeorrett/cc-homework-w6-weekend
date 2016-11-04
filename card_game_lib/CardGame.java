package card_game_lib;

import java.util.*;

public class CardGame {

  private Player[] players;
  private Deck deck;
  private int numberOfPlayers;

  public CardGame( String[] playerNames ) {

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

}
