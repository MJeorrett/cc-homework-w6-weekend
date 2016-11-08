import blackjack.*;
import card_game_lib.*;
import card_game_lib.french_deck.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BlackjackTest {

  private ArrayList<BJPlayerable> playersWinnerFirst;
  private ArrayList<BJPlayerable> playersWinnerLast;
  private ArrayList<BJPlayerable> playersTwoWayDraw;

  private AIBJPlayer testPlayer;
  private AIBJPlayer blackjackPlayer;
  private AIBJPlayer winningPlayer;
  private AIBJPlayer losingPlayer1;
  private AIBJPlayer losingPlayer2;

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

    this.blackjackPlayer = new AIBJPlayer( "Blackjack Player");
    this.testPlayer = new AIBJPlayer( "Test Player");

    this.twoOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.TWO );
    this.fiveOfClubs = new Card( FrenchSuit.CLUBS, FrenchRank.FIVE );
    this.sevenOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.SEVEN );
    this.jackOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.JACK );
    this.kingOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.KING );
    this.aceOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.ACE );
    this.aceOfClubs = new Card( FrenchSuit.CLUBS, FrenchRank.ACE );
    this.aceOfDiamonds = new Card( FrenchSuit.DIAMONDS, FrenchRank.ACE );
    this.aceOfSpades = new Card( FrenchSuit.SPADES, FrenchRank.ACE );

    this.blackjackPlayer.addCard( this.kingOfSpades );
    this.blackjackPlayer.addCard( this.aceOfClubs );

    this.winningPlayer = new AIBJPlayer( "Winner" );
    winningPlayer.addCard( this.kingOfSpades );
    winningPlayer.addCard( this.aceOfClubs );

    this.losingPlayer1 = new AIBJPlayer( "Loser 1" );
    losingPlayer1.addCard( this.twoOfHearts );
    losingPlayer1.addCard( this.jackOfDiamonds );

    this.losingPlayer2 = new AIBJPlayer( "Loser 2" );
    losingPlayer2.addCard( this.sevenOfSpades );
    losingPlayer2.addCard( this.jackOfDiamonds );

    this.playersWinnerFirst = new ArrayList<BJPlayerable>();
    this.playersWinnerFirst.add( winningPlayer );
    this.playersWinnerFirst.add( losingPlayer1 );
    this.playersWinnerFirst.add( losingPlayer2 );

    this.playersWinnerLast = new ArrayList<BJPlayerable>();
    this.playersWinnerLast.add( losingPlayer1 );
    this.playersWinnerLast.add( losingPlayer2 );
    this.playersWinnerLast.add( winningPlayer );

    this.playersTwoWayDraw = new ArrayList<BJPlayerable>();
    this.playersTwoWayDraw.add( losingPlayer1 );
    this.playersTwoWayDraw.add( winningPlayer );
    this.playersTwoWayDraw.add( losingPlayer2 );
    this.playersTwoWayDraw.add( losingPlayer2 );
    this.playersTwoWayDraw.add( winningPlayer );
  }

  @Test
  public void canScorePlayerWithoutAces() {

    this.testPlayer.addCard( this.fiveOfClubs );
    this.testPlayer.addCard( this.kingOfSpades );

    assertEquals( 15, Blackjack.scorePlayer( this.testPlayer ) );
  }

  @Test
  public void canScorePlayerWithAceLow() {

    this.testPlayer.addCard( this.fiveOfClubs );
    this.testPlayer.addCard( this.kingOfSpades );
    this.testPlayer.addCard( this.aceOfClubs );

    assertEquals( 16, Blackjack.scorePlayer( this.testPlayer ) );
  }

  @Test
  public void canScorePlayerWithAceHigh() {

    this.testPlayer.addCard( this.fiveOfClubs );
    this.testPlayer.addCard( this.aceOfClubs );

    assertEquals( 16, Blackjack.scorePlayer( this.testPlayer ) );
  }

  @Test
  public void canScorePlayerWithMultipleAces() {

    this.testPlayer.addCard( this.aceOfHearts );
    this.testPlayer.addCard( this.aceOfClubs );
    this.testPlayer.addCard( this.aceOfDiamonds );
    this.testPlayer.addCard( this.aceOfSpades );

    assertEquals( 14, Blackjack.scorePlayer( this.testPlayer ) );
  }

  @Test
  public void canScoreBlackjack() {

    assertEquals( 21, Blackjack.scorePlayer( this.blackjackPlayer ) );
  }

  @Test
  public void bustWhen22() {

    this.testPlayer.addCard( this.kingOfSpades );
    this.testPlayer.addCard( this.jackOfDiamonds );
    this.testPlayer.addCard( this.twoOfHearts );

    assertEquals( 22, Blackjack.scorePlayer( this.testPlayer ) );
    assertEquals( true, Blackjack.isBust( this.testPlayer ) );
  }

  @Test
  public void blackjackIsNotBust() {

    assertEquals( false, Blackjack.isBust( this.blackjackPlayer ) );
  }

  @Test
  public void notBustWhen20() {

    this.testPlayer.addCard( this.jackOfDiamonds );
    this.testPlayer.addCard( this.kingOfSpades );

    assertEquals( false, Blackjack.isBust( this.testPlayer ) );
  }

  @Test
  public void winningPlayersPlayerFirst() {
    ArrayList<BJPlayerable> expected = new ArrayList<BJPlayerable>();
    expected.add( this.winningPlayer );

    ArrayList<BJPlayerable> actual = Blackjack.winningPlayers( this.playersWinnerFirst );

    assertEquals( 1, actual.size() );
    assertEquals( expected, actual );
  }

  @Test
  public void winningPlayersPlayerLast() {
    ArrayList<BJPlayerable> expected = new ArrayList<BJPlayerable>();
    expected.add( this.winningPlayer );

    ArrayList<BJPlayerable> actual = Blackjack.winningPlayers( this.playersWinnerLast );

    assertEquals( 1, actual.size() );
    assertEquals( expected, actual );
  }

  @Test
  public void winningPlayersTwoWayDraw() {
    ArrayList<BJPlayerable> expected = new ArrayList<BJPlayerable>();
    expected.add( this.winningPlayer );
    expected.add( this.winningPlayer );

    ArrayList<BJPlayerable> actual = Blackjack.winningPlayers( this.playersTwoWayDraw );

    assertEquals( 2, actual.size() );
    assertEquals( expected, actual );
  }

}
