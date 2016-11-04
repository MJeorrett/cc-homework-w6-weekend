import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class PlayerTest {

  Player testPlayer;
  Card threeOfSpades;
  Card fiveOfDiamonds;

  @Before
  public void before() {
    this.testPlayer = new Player( "Martin" );
    this.threeOfSpades = new Card( Suit.SPADES, Rank.THREE );
    this.fiveOfDiamonds = new Card( Suit.DIAMONDS, Rank.FIVE );
  }

  @Test
  public void hasName() {
    assertEquals( "Martin", this.testPlayer.getName() );
  }

  @Test
  public void hasCardAfterAdding() {
    this.testPlayer.addCard( this.threeOfSpades );
    assertEquals( true, this.testPlayer.hasCard( this.threeOfSpades ) );
  }

  @Test
  public void removeCard() {
    this.testPlayer.addCard( this.threeOfSpades );
    this.testPlayer.addCard( this.fiveOfDiamonds );
    this.testPlayer.removeCard( this.threeOfSpades );
    assertEquals( false, this.testPlayer.hasCard( this.threeOfSpades));
    assertEquals( true, this.testPlayer.hasCard( this.fiveOfDiamonds));
  }
}
