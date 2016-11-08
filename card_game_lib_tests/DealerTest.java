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

  private ArrayList<BJPlayerable> testPlayers;

  private Player testPlayer;

  private Card threeOfHearts;

  @Before
  public void before() throws DeckEmptyException {

    this.testPlayers = new ArrayList<BJPlayerable>();
    testPlayers.add( new AIBJPlayer( "James" ) );
    testPlayers.add( new AIBJPlayer( "Mark" ) );
    testPlayers.add( new AIBJPlayer( "Derek" ) );
    testPlayers.add( new AIBJPlayer( "Matthew" ) );

    this.testDealer = new Dealer( this.testPlayers, new FrenchDeck() );

    Deck deck = new FrenchDeck();
    Deck spyDeck = spy( deck );

    this.threeOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.THREE );
    Mockito.when( spyDeck.dealCard() ).thenReturn( this.threeOfHearts );

    this.threeOfHeartsDealer = new Dealer( this.testPlayers, spyDeck );

    this.testPlayer = new AIBJPlayer( "John" );
  }

  @Test
  public void hasCorrectNumberOfPlayers() {
    assertEquals( 4, this.testDealer.numberOfPlayers() );
  }

  @Test
  public void canDealRound() throws DeckEmptyException {

    this.testDealer.dealRound();

    for ( Playerable player : this.testPlayers ) {
      assertEquals( 1, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealRounds() throws DeckEmptyException {

    this.testDealer.dealRounds( 5 );

    for ( Playerable player : this.testPlayers ) {
      assertEquals( 5, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealCardToPlayer() throws DeckEmptyException {
    this.testDealer.dealCardToPlayer( (Dealable)this.testPlayer );
    assertEquals( 1, this.testPlayer.cardsRemaining() );
  }

  @Test
  public void playerRecievesDealtCard() throws DeckEmptyException {
    this.threeOfHeartsDealer.dealCardToPlayer( (Dealable)this.testPlayer );
    assertEquals( true, this.testPlayer.hasCard( this.threeOfHearts ) );
  }

}
