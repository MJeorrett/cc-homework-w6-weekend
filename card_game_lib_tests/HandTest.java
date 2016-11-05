import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.*;

import card_game_lib.*;

public class HandTest {

  private Hand testHand;
  private Card fiveOfClubs;
  private Card kingOfSpades;
  private Card aceOfDiamonds;
  private Card aceOfSpades;

  @Before
  public void before() {
    this.testHand = new Hand();
    this.fiveOfClubs = new Card( Suit.CLUBS, Rank.FIVE );
    this.kingOfSpades = new Card( Suit.SPADES, Rank.KING );
    this.aceOfDiamonds = new Card( Suit.DIAMONDS, Rank.ACE );
    this.aceOfSpades = new Card( Suit.SPADES, Rank.ACE );
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

  @Test
  public void canGetCards() {

    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.addCard( this.kingOfSpades );
    Card[] expected = { this.fiveOfClubs, this.kingOfSpades };
    assertArrayEquals( expected, this.testHand.getCards() );
  }

  @Test
  public void canToDisStr() {
    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.addCard( this.aceOfDiamonds );
    this.testHand.addCard( this.kingOfSpades );
    this.testHand.addCard( this.aceOfSpades );
    String expected = "5 of Clubs\nAce of Diamonds\nKing of Spades\nAce of Spades\n";
    assertEquals( expected, this.testHand.toDisStr() );
  }

}
