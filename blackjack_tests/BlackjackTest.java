import static org.junit.Assert.assertEquals;
import org.junit.*;

import blackjack.*;
import card_game_lib.*;

public class BlackjackTest {

  private Hand testHand;
  private Card fiveOfClubs;
  private Card kingOfSpades;
  private Card aceOfHearts;
  private Card aceOfClubs;
  private Card aceOfDiamonds;
  private Card aceOfSpades;
  private Blackjack game;

  @Before
  public void before() {
    this.testHand = new Hand();

    this.fiveOfClubs = new Card( Suit.CLUBS, Rank.FIVE );
    this.kingOfSpades = new Card( Suit.SPADES, Rank.KING );
    this.aceOfHearts = new Card( Suit.HEARTS, Rank.ACE );
    this.aceOfClubs = new Card( Suit.CLUBS, Rank.ACE );
    this.aceOfDiamonds = new Card( Suit.DIAMONDS, Rank.ACE );
    this.aceOfSpades = new Card( Suit.SPADES, Rank.ACE );
  }

  @Test
  public void canScoreHandWithoutAces() {

    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.addCard( this.kingOfSpades );

    assertEquals( 15, Blackjack.scoreHand( this.testHand ) );
  }

  @Test
  public void canScoreHandWithAceLow() {

    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.addCard( this.kingOfSpades );
    this.testHand.addCard( this.aceOfClubs );

    assertEquals( 16, Blackjack.scoreHand( this.testHand ) );
  }

  @Test
  public void canScoreHandWithAceHigh() {

    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.addCard( this.aceOfClubs );

    assertEquals( 16, Blackjack.scoreHand( this.testHand ) );
  }

  @Test
  public void canScoreHandWithMultipleAces() {

    this.testHand.addCard( this.aceOfHearts );
    this.testHand.addCard( this.aceOfClubs );
    this.testHand.addCard( this.aceOfDiamonds );
    this.testHand.addCard( this.aceOfSpades );

    assertEquals( 14, Blackjack.scoreHand( this.testHand ) );
  }

  @Test
  public void canScoreBlackjack() {

    this.testHand.addCard( this.kingOfSpades );
    this.testHand.addCard( this.aceOfClubs );

    assertEquals( 21, Blackjack.scoreHand( this.testHand ) );
  }

}
