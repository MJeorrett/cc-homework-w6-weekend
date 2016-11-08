package card_game_lib;

import java.util.*;

public interface Playerable {
  String getName();
  ArrayList<Card> getCards();
  int cardsRemaining();
}
