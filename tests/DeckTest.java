package card_game_lib;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class DeckTest {

  private Deck testDeck;

  @Before
  public void before() {
    this.testDeck = new Deck();
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

}
