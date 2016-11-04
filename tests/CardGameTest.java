import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class CardGameTest {

  private CardGame cardGame;

  @Before
  public void before() {
    String[] playerNames = { "James", "Mark", "Derek", "Matthew" };
    this.cardGame = new CardGame( playerNames );
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
  public void playersHaveCardsAfterDealing() {
    this.cardGame.dealCards();
    Player[] players = this.cardGame.getPlayers();

    for ( Player player : players ) {
      assertEquals( 1, player.cardCount() );
    }
  }

}
