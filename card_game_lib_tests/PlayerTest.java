import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;
import card_game_lib.french_deck.*;
import blackjack.*;

public class PlayerTest {

  private Player testPlayer;

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
    this.testPlayer = new AIBJPlayer( "Martin" );

    this.twoOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.TWO );
    this.fiveOfClubs = new Card( FrenchSuit.CLUBS, FrenchRank.FIVE );
    this.jackOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.JACK );
    this.kingOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.KING );
    this.aceOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.ACE );
    this.aceOfClubs = new Card( FrenchSuit.CLUBS, FrenchRank.ACE );
    this.aceOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.ACE );
    this.aceOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.ACE );
  }

  @Test
  public void hasName() {
    assertEquals( "Martin", this.testPlayer.getName() );
  }

  @Test
  public void canToDisStr() {

    this.testPlayer.addCard( this.fiveOfClubs );
    this.testPlayer.addCard( this.aceOfDiamonds );
    this.testPlayer.addCard( this.kingOfSpades );
    this.testPlayer.addCard( this.aceOfSpades );

    String expected = "Martin's cards:\n5 of Clubs\nAce of Diamonds\nKing of Spades\nAce of Spades\n";

    assertEquals( expected, this.testPlayer.toDisStr() );
  }
}
