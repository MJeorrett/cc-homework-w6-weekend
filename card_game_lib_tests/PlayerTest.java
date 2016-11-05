import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

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
    this.testPlayer = new Player( "Martin" );

    this.twoOfHearts = new Card( Suit.HEARTS, Rank.TWO );
    this.fiveOfClubs = new Card( Suit.CLUBS, Rank.FIVE );
    this.jackOfDiamonds = new Card( Suit.DIAMONDS, Rank.JACK );
    this.kingOfSpades = new Card( Suit.SPADES, Rank.KING );
    this.aceOfHearts = new Card( Suit.HEARTS, Rank.ACE );
    this.aceOfClubs = new Card( Suit.CLUBS, Rank.ACE );
    this.aceOfDiamonds = new Card( Suit.DIAMONDS, Rank.ACE );
    this.aceOfSpades = new Card( Suit.SPADES, Rank.ACE );
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
