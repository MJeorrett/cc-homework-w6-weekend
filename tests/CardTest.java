package card_game_lib;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class CardTest {

  private Card tenOfHearts;

  @Before
  public void before() {
    this.tenOfHearts = new Card( Suit.HEARTS, Rank.TEN );
  }

  @Test
  public void canGetSuit() {
    assertEquals( Suit.HEARTS, this.tenOfHearts.getSuit() );
  }

  @Test
  public void canGetRank() {
    assertEquals( Rank.TEN, this.tenOfHearts.getRank() );
  }

  @Test
  public void canToString() {
    assertEquals( "10 of Hearts", this.tenOfHearts.toString() );
  }

  @Test
  public void sameRankAndSuitEqualsTrue() {
    Card tenOfHearts_2 = new Card( Suit.HEARTS, Rank.TEN );
    assertEquals( true, this.tenOfHearts.equals( tenOfHearts_2 ) );
  }

}
