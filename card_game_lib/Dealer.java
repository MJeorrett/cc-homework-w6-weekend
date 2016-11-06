package card_game_lib;

public class Dealer {

  private Player[] players;
  private Deck deck;

  public Dealer( String[] playerNames, Deck deck ) {

    this.deck = deck;

    int numberOfPlayers = playerNames.length;

    this.players = new Player[numberOfPlayers];

    for ( int i = 0; i < numberOfPlayers; i++ ) {
      Player player = new Player( playerNames[i] );
      this.players[i] = player;
    }
  }

  public int numberOfPlayers() {
    return players.length;
  }

  public Player[] getPlayers() {
    return this.players;
  }

  public void dealRound() {
    for ( Player player : this.players ) {
      player.addCard( this.deck.dealCard() );
    }
  }

  public void dealRounds( int number ) {

    for ( int i = 0; i < number; i++ ) {

      this.dealRound();
    }
  }

  public void dealCardToPlayer( Player player ) {
    player.addCard( this.deck.dealCard() );
  }

}
