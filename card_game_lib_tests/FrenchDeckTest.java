import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class FrenchDeckTest {

  private Deck testDeck;

  @Before
  public void before() {
    this.testDeck = new FrenchDeck();
  }

  @Test
  public void newDeckHasAllCards() {
    for ( Suit suit : Suit.values() ) {
      for ( Rank rank : Rank.values() ) {
        Card card = new Card( suit, rank );
        assertEquals( true, this.testDeck.hasCard( card ) );
      }
    }
  }

  @Test
  public void dealCardRemovesCard() {
    Card card = this.testDeck.dealCard();
    assertEquals( false, this.testDeck.hasCard( card ) );
  }

  @Test
  public void newDeckHas52Cards() {
    assertEquals( 52, this.testDeck.cardsRemaining() );
  }

}
