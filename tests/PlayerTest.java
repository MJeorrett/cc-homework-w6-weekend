import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class PlayerTest {

  Player testPlayer;
  Card threeOfSpades;

  @Before
  public void before() {
    this.testPlayer = new Player( "Martin" );
    this.threeOfSpades = new Card( Suit.SPADES, Rank.THREE );
  }

  @Test
  public void hasName() {
    assertEquals( "Martin", this.testPlayer.getName() );
  }

  @Test
  public void hasCardAfterTaking() {
    this.testPlayer.addCard( this.threeOfSpades );
    assertEquals( true, this.testPlayer.hasCard( this.threeOfSpades ) );
  }

}
