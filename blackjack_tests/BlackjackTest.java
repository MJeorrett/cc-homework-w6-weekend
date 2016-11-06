import blackjack.*;
import card_game_lib.*;
import card_game_lib.french_deck.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BlackjackTest {

  private ArrayList<BlackjackPlayer> playersWinnerFirst;
  private ArrayList<BlackjackPlayer> playersWinnerLast;
  private ArrayList<BlackjackPlayer> playersTwoWayDraw;

  private BlackjackPlayer winningPlayer;
  private BlackjackPlayer losingPlayer1;
  private BlackjackPlayer losingPlayer2;

  private Hand testHand;
  private Hand blackjackHand;

  private Card twoOfHearts;
  private Card fiveOfClubs;
  private Card sevenOfSpades;
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
    this.sevenOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.SEVEN );
    this.jackOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.JACK );
    this.kingOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.KING );
    this.aceOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.ACE );
    this.aceOfClubs = new Card( FrenchSuit.CLUBS, FrenchRank.ACE );
    this.aceOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.ACE );
    this.aceOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.ACE );

    this.blackjackHand.addCard( this.kingOfSpades );
    this.blackjackHand.addCard( this.aceOfClubs );

    this.winningPlayer = new BlackjackPlayer( "Winner" );
    winningPlayer.addCard( this.kingOfSpades );
    winningPlayer.addCard( this.aceOfClubs );

    this.losingPlayer1 = new BlackjackPlayer( "Loser 1" );
    losingPlayer1.addCard( this.twoOfHearts );
    losingPlayer1.addCard( this.jackOfDiamonds );

    this.losingPlayer2 = new BlackjackPlayer( "Loser 2" );
    losingPlayer2.addCard( this.sevenOfSpades );
    losingPlayer2.addCard( this.jackOfDiamonds );

    this.playersWinnerFirst = new ArrayList<BlackjackPlayer>();
    this.playersWinnerFirst.add( winningPlayer );
    this.playersWinnerFirst.add( losingPlayer1 );
    this.playersWinnerFirst.add( losingPlayer2 );

    this.playersWinnerLast = new ArrayList<BlackjackPlayer>();
    this.playersWinnerLast.add( losingPlayer1 );
    this.playersWinnerLast.add( losingPlayer2 );
    this.playersWinnerLast.add( winningPlayer );

    this.playersTwoWayDraw = new ArrayList<BlackjackPlayer>();
    this.playersTwoWayDraw.add( losingPlayer1 );
    this.playersTwoWayDraw.add( winningPlayer );
    this.playersTwoWayDraw.add( losingPlayer2 );
    this.playersTwoWayDraw.add( losingPlayer2 );
    this.playersTwoWayDraw.add( winningPlayer );
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

  @Test
  public void winningPlayersPlayerFirst() {
    ArrayList<BlackjackPlayer> expected = new ArrayList<BlackjackPlayer>();
    expected.add( this.winningPlayer );

    ArrayList<BlackjackPlayer> actual = Blackjack.winningPlayers( this.playersWinnerFirst );

    assertEquals( 1, actual.size() );
    assertEquals( expected, actual );
  }

  @Test
  public void winningPlayersPlayerLast() {
    ArrayList<BlackjackPlayer> expected = new ArrayList<BlackjackPlayer>();
    expected.add( this.winningPlayer );

    ArrayList<BlackjackPlayer> actual = Blackjack.winningPlayers( this.playersWinnerLast );

    assertEquals( 1, actual.size() );
    assertEquals( expected, actual );
  }

  @Test
  public void winningPlayersTwoWayDraw() {
    ArrayList<BlackjackPlayer> expected = new ArrayList<BlackjackPlayer>();
    expected.add( this.winningPlayer );
    expected.add( this.winningPlayer );

    ArrayList<BlackjackPlayer> actual = Blackjack.winningPlayers( this.playersTwoWayDraw );

    assertEquals( 2, actual.size() );
    assertEquals( expected, actual );
  }

}
