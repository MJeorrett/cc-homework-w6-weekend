import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

import card_game_lib.*;
import card_game_lib.french_deck.*;
import card_game_lib.user_interface.*;
import blackjack.*;

public class DealerTest {

  private Dealer testDealer;
  private Dealer threeOfHeartsDealer;

  private Player testPlayer;

  private Card threeOfHearts;

  @Before
  public void before() {

    String[] playerNames = { "James", "Mark", "Derek", "Matthew" };

    this.testDealer = new Dealer( playerNames, new FrenchDeck() );

    Deck deck = new FrenchDeck();
    Deck spyDeck = spy( deck );

    this.threeOfHearts = new Card( FrenchSuit.HEARTS, FrenchRank.THREE );
    Mockito.when( spyDeck.dealCard() ).thenReturn( this.threeOfHearts );

    this.threeOfHeartsDealer = new Dealer( playerNames, spyDeck );

    this.testPlayer = new BlackjackPlayer( "John" );
  }

  @Test
  public void hasCorrectNumberOfPlayers() {
    assertEquals( 4, this.testDealer.numberOfPlayers() );
  }

  @Test
  public void canDealRound() {

    this.testDealer.dealRound();

    Player[] players = this.testDealer.getPlayers();

    for ( Player player : players ) {
      assertEquals( 1, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealRounds() {

    this.testDealer.dealRounds( 5 );

    Player[] players = this.testDealer.getPlayers();

    for ( Player player : players ) {
      assertEquals( 5, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealCardToPlayer() {
    this.testDealer.dealCardToPlayer( this.testPlayer );
    assertEquals( 1, this.testPlayer.cardsRemaining() );
  }

  @Test
  public void playerRecievesDealtCard() {
    this.threeOfHeartsDealer.dealCardToPlayer( this.testPlayer );
    assertEquals( true, this.testPlayer.hasCard( this.threeOfHearts ) );
  }

}
