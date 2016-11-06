import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;
import card_game_lib.french_deck.*;

public class CardTest {

  private Card tenOfHearts;

  @Before
  public void before() {
    this.tenOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.TEN );
  }

  @Test
  public void canGetSuit() {
    assertEquals( FrenchSuit.HEARTS, this.tenOfHearts.getSuit() );
  }

  @Test
  public void canGetRank() {
    assertEquals( FrenchRank.TEN, this.tenOfHearts.getRank() );
  }

  @Test
  public void canToDisStr() {
    assertEquals( "10 of Hearts", this.tenOfHearts.toDisStr() );
  }

  @Test
  public void sameRankAndSuitEqualsTrue() {
    Card tenOfHearts_2 = new Card( FrenchSuit.HEARTS, FrenchRank.TEN );
    assertEquals( true, this.tenOfHearts.equals( tenOfHearts_2 ) );
  }

  @Test
  public void differentRankSameSuitEqualsFalse() {
    Card tenOfHearts_2 = new Card( FrenchSuit.HEARTS, FrenchRank.EIGHT );
    assertEquals( false, this.tenOfHearts.equals( tenOfHearts_2 ) );
  }

  @Test
  public void sameRankDifferentSuitEqualsFalse() {
    Card tenOfHearts_2 = new Card( FrenchSuit.DIAMONDS, FrenchRank.TEN );
    assertEquals( false, this.tenOfHearts.equals( tenOfHearts_2 ) );
  }

}
