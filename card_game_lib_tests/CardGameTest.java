import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.anyInt;

import org.junit.*;
import org.mockito.*;

import card_game_lib.*;
import card_game_lib.user_interface.*;
import blackjack.*;

public class CardGameTest {

  private CardGame cardGame;
  private Player testPlayer;
  private Interfaceable spyUserInterface;

  @Before
  public void before() {

    UserInterface userInterface = new UserInterface();
    this.spyUserInterface = Mockito.spy( userInterface );

    String[] playerNames = { "James", "Mark", "Derek", "Matthew" };
    doReturn( playerNames ).when( spyUserInterface ).getPlayerNames( anyInt(), anyInt() );

    this.cardGame = new Blackjack( this.spyUserInterface );
    this.testPlayer = new Player( "John" );
  }

  @Test
  public void hasCorrectNumberOfPlayers() {
    assertEquals( 4, this.cardGame.numberOfPlayers() );
  }

  @Test
  public void canDealRound() {
    this.cardGame.dealRound();
    Player[] players = this.cardGame.getPlayers();

    for ( Player player : players ) {
      assertEquals( 1, player.cardsRemaining() );
    }
  }

  @Test
  public void canDealCardToPlayer() {
    this.cardGame.dealCardToPlayer( this.testPlayer );
    assertEquals( 1, this.testPlayer.cardsRemaining() );
  }

}
