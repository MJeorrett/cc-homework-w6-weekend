import blackjack.*;
import card_game_lib.*;
import card_game_lib.french_deck.*;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BlackjackTest {

  private Hand testHand;
  private Hand blackjackHand;

  private Card twoOfHearts;
  private Card fiveOfClubs;
  private Card jackOfDiamonds;
  private Card kingOfSpades;
  private Card aceOfHearts;
  private Card aceOfClubs;
  private Card aceOfDiamonds;
  private Card aceOfSpades;

  @Before
  public void before() {
    this.testHand = new Hand();
    this.blackjackHand = new Hand();

    this.twoOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.TWO );
    this.fiveOfClubs = new Card( FrenchSuit.CLUBS, FrenchRank.FIVE );
    this.jackOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.JACK );
    this.kingOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.KING );
    this.aceOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.ACE );
    this.aceOfClubs = new Card( FrenchSuit.CLUBS, FrenchRank.ACE );
    this.aceOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.ACE );
    this.aceOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.ACE );

    this.blackjackHand.addCard( this.kingOfSpades );
    this.blackjackHand.addCard( this.aceOfClubs );
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

    assertEquals( 21, Blackjack.scoreHand( this.blackjackHand ) );
  }

  @Test
  public void bustWhen22() {

    this.testHand.addCard( this.kingOfSpades );
    this.testHand.addCard( this.jackOfDiamonds );
    this.testHand.addCard( this.twoOfHearts );

    assertEquals( 22, Blackjack.scoreHand( this.testHand ) );
    assertEquals( true, Blackjack.isBust( this.testHand ) );
  }

  @Test
  public void blackjackIsNotBust() {

    assertEquals( false, Blackjack.isBust( this.blackjackHand ) );
  }

  @Test
  public void notBustWhen20() {

    this.testHand.addCard( this.jackOfDiamonds );
    this.testHand.addCard( this.kingOfSpades );

    assertEquals( false, Blackjack.isBust( this.blackjackHand ) );
  }

}
