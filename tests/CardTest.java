import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class CardTest {

  Card tenOfHearts;

  @Before
  public void before() {
    this.tenOfHearts = new Card( Suit.HEARTS, Rank.TEN );
  }

  @Test
  public void getSuit() {
    assertEquals( Suit.HEARTS, this.tenOfHearts.getSuit() );
  }

  @Test
  public void getRank() {
    assertEquals( Rank.TEN, this.tenOfHearts.getRank() );
  }

  @Test
  public void toString() {
    assertEquals( "10 of Hearts", this.tenOfHearts.toString() );
  }

}
