package blackjack;

import card_game_lib.*;

import java.util.*;

public interface BJPlayerable extends Playerable, Dealable {

  boolean isSticking();
}
