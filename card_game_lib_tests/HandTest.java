import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class HandTest {

  private Hand testHand;
  private Card fiveOfClubs;
  private Card kingOfSpades;

  @Before
  public void before() {
    this.testHand = new Hand();
    this.fiveOfClubs = new Card( Suit.CLUBS, Rank.FIVE );
    this.kingOfSpades = new Card( Suit.SPADES, Rank.KING );
  }

  @Test
  public void addCardAddsCard() {
    this.testHand.addCard( this.fiveOfClubs );
    assertEquals( true, this.testHand.hasCard( this.fiveOfClubs ) );
  }

  @Test
  public void cardCountInitiallyZero() {
    assertEquals( 0, this.testHand.cardCount() );
  }

  @Test
  public void addCardIncreasesCardCount() {
    this.testHand.addCard( this.fiveOfClubs );
    assertEquals( 1, this.testHand.cardCount() );
    this.testHand.addCard( this.kingOfSpades );
    assertEquals( 2, this.testHand.cardCount() );
  }

  @Test
  public void removeCard() {
    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.removeCard( this.fiveOfClubs );
    assertEquals( false, this.testHand.hasCard( this.fiveOfClubs ) );
  }

}
