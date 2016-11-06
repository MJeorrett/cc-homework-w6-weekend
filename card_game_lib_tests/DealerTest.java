import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import card_game_lib.*;
import card_game_lib.french_deck.*;
import card_game_lib.user_interface.*;
import blackjack.*;

import java.util.*;
import org.junit.*;
import org.mockito.*;

public class DealerTest {

  private Dealer testDealer;
  private Dealer threeOfHeartsDealer;

  private ArrayList<BlackjackPlayer> testPlayers;

  private Player testPlayer;

  private Card threeOfHearts;

  @Before
  public void before() {

    this.testPlayers = new ArrayList<BlackjackPlayer>();
    testPlayers.add( new BlackjackPlayer( "James" ) );
    testPlayers.add( new BlackjackPlayer( "Mark" ) );
    testPlayers.add( new BlackjackPlayer( "Derek" ) );
    testPlayers.add( new BlackjackPlayer( "Matthew" ) );

    this.testDealer = new Dealer( this.testPlayers, new FrenchDeck() );

    Deck deck = new FrenchDeck();
    Deck spyDeck = spy( deck );

    this.threeOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.THREE );
    Mockito.when( spyDeck.dealCard() ).thenReturn( this.threeOfHearts );

    this.threeOfHeartsDealer = new Dealer( this.testPlayers, spyDeck );

    this.testPlayer = new BlackjackPlayer( "John" );
  }

  @Test
  public void hasCorrectNumberOfPlayers() {
    assertEquals( 4, this.testDealer.numberOfPlayers() );
  }

  @Test
  public void canDealRound() {

    this.testDealer.dealRound();

    for ( Player player : this.testPlayers ) {
      assertEquals( 1, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealRounds() {

    this.testDealer.dealRounds( 5 );

    for ( Player player : this.testPlayers ) {
      assertEquals( 5, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealCardToPlayer() {
    this.testDealer.dealCardToPlayer( (Dealable)this.testPlayer );
    assertEquals( 1, this.testPlayer.cardsRemaining() );
  }

  @Test
  public void playerRecievesDealtCard() {
    this.threeOfHeartsDealer.dealCardToPlayer( (Dealable)this.testPlayer );
    assertEquals( true, this.testPlayer.hasCard( this.threeOfHearts ) );
  }

}
