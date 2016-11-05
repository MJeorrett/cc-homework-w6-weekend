import static org.junit.Assert.assertEquals;

import org.junit.*;

import card_game_lib.*;
import card_game_lib.user_interface.*;

public class DealerTest {

  private Dealer dealer;
  private Player testPlayer;

  @Before
  public void before() {

    String[] playerNames = { "James", "Mark", "Derek", "Matthew" };

    this.dealer = new Dealer( playerNames );
    this.testPlayer = new Player( "John" );
  }

  @Test
  public void hasCorrectNumberOfPlayers() {
    assertEquals( 4, this.dealer.numberOfPlayers() );
  }

  @Test
  public void canDealRound() {
    this.dealer.dealRound();
    Player[] players = this.dealer.getPlayers();

    for ( Player player : players ) {
      assertEquals( 1, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealCardToPlayer() {
    this.dealer.dealCardToPlayer( this.testPlayer );
    assertEquals( 1, this.testPlayer.cardsRemaining() );
  }

}
