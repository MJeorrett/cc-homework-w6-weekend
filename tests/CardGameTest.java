import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class CardGameTest {

  private CardGame cardGame;
  private Player testPlayer;

  @Before
  public void before() {
    String[] playerNames = { "James", "Mark", "Derek", "Matthew" };
    this.cardGame = new CardGame( playerNames );
    this.testPlayer = new Player( "John" );
  }

  @Test
  public void hasCorrectNumberOfPlayers() {
    assertEquals( 4, this.cardGame.numberOfPlayers() );
  }

  @Test
  public void correctNumberOfPlayersCreated() {
    assertEquals( 4, this.cardGame.getPlayers().length );
  }

  @Test
  public void canDealRound() {
    this.cardGame.dealRound();
    Player[] players = this.cardGame.getPlayers();

    for ( Player player : players ) {
      assertEquals( 1, player.cardCount() );
    }
  }

  @Test
  public void canDealCardToPlayer() {
    this.cardGame.dealCardToPlayer( this.testPlayer );
    assertEquals( 1, this.testPlayer.cardCount() );
  }

}
