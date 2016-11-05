import static org.junit.Assert.assertEquals;
import org.junit.*;

import blackjack.*;
import card_game_lib.*;

public class BlackjackTest {

  private Hand testHand;
  private Card fiveOfClubs;
  private Card kingOfSpades;
  private Blackjack game;

  @Before
  public void before() {
    this.testHand = new Hand();
    this.fiveOfClubs = new Card( Suit.CLUBS, Rank.FIVE );
    this.kingOfSpades = new Card( Suit.SPADES, Rank.KING );

    this.testHand.addCard( this.fiveOfClubs );
    this.testHand.addCard( this.kingOfSpades );

    // this.game = new Blackjack();
  }

  @Test
  public void canScoreHandWithoutAces() {
    assertEquals( 15, Blackjack.scoreHand( this.testHand ) );
  }

}
