import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;
import card_game_lib.french_deck.*;

public class FrenchDeckTest {

  private Deck testDeck;

  @Before
  public void before() {
    this.testDeck = new FrenchDeck();
  }

  @Test
  public void newDeckHasAllCards() {
    for ( FrenchSuit suit : FrenchSuit.values() ) {
      for ( FrenchRank rank : FrenchRank.values() ) {
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
