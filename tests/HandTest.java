import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class HandTest {

  private Hand testHand;
  private Card fiveOfClubs;

  @Before
  public void before() {
    this.testHand = new Hand();
    this.fiveOfClubs = new Card( Suit.CLUBS, Rank.FIVE );
  }

  @Test
  public void handDoesntHaveCardWhenInitialised() {
    assertEquals( false, this.testHand.hasCard( this.fiveOfClubs ) );
  }

  @Test
  public void addCardAddsCard() {
    this.testHand.addCard( this.fiveOfClubs );
    assertEquals( true, this.testHand.hasCard( this.fiveOfClubs ) );
  }

  @Test
  public void removeCard() {
    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.removeCard( this.fiveOfClubs );
    assertEquals( false, this.testHand.hasCard( this.fiveOfClubs ) );
  }

}
