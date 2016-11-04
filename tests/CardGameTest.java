import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class CardGameTest {

  private CardGame cardGame;

  @Before
  public void before() {
    this.cardGame = new CardGame();
    String[] playerNames = { "James", "Mark", "Derek", "Matthew" };
    this.cardGame.startGame( playerNames );
  }

  @Test
  public void hasRightNumberOfPlayers() {
    assertEquals( 4, this.cardGame.numberOfPlayers() );
  }

}
