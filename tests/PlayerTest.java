import static org.junit.Assert.assertEquals;
import org.junit.*;

import card_game_lib.*;

public class PlayerTest {

  Player testPlayer;

  @Before
  public void before() {
    this.testPlayer = new Player( "Martin" );
  }

  @Test
  public void hasName() {
    assertEquals( "Martin", this.testPlayer.getName() );
  }

}
