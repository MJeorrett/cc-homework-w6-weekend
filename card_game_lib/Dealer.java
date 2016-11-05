package card_game_lib;

public class Dealer {

  private Player[] players;
  private Deck deck;
  private int numberOfPlayers;

  public Dealer( String[] playerNames ) {

    this( playerNames, Dealer.getDefaultDeck() );
  }

  public Dealer( String[] playerNames, Deck deck ) {

    this.deck = deck;

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

  public void dealRounds( int number ) {

    for ( int i = 0; i < number; i++ ) {
      
      this.dealRound();
    }
  }

  public void dealCardToPlayer( Player player ) {
    player.addCard( this.deck.dealCard() );
  }

  private static Deck getDefaultDeck() {

    Deck deck = new Deck();
    deck.shuffle();

    return deck;
  }

}
