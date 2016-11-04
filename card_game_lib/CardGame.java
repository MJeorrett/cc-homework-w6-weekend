package card_game_lib;

import java.util.*;

public class CardGame {

  private ArrayList<Player> players;
  private Deck deck;

  public CardGame() {

  }

  public void startGame( String[] playerNames ) {
    this.players = new ArrayList<Player>();

    for ( String playerName : playerNames ) {
      Player player = new Player( playerName );
      players.add( player );
    }
  }

  public int numberOfPlayers() {
    return players.size();
  }

}
