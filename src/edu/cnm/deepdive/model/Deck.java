package edu.cnm.deepdive.model;

import edu.cnm.deepdive.model.Suit.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Encapsulates playing cards in a {@link List}.
 */
public class Deck {

  private List<Card> cards;
  private List<Card> dealt;

  /**
   * Initializes the Deck instance with the specified {@link Suit} and {@link Rank} in an ordered
   * list, not random.
   */
  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

  /**
   * Deals playing cards from a deck of 52 cards until no cards are left.
   * @return {@link Card} value.
   */
  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  /**
   * Initializes the shuffle instance with the specified {@link Random}.
   *
   * @param rng {@link Random} deals a random card.
   */
  public void shuffle(Random rng) {
    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    // Gathers cards together in single deck.
    cards.addAll(dealt);
    dealt.clear();
  }

  /**
   * Returns {@link #cards} remaining instance value for this suit.
   *
   * @return {@link #cards} value.
   */
  public int remaining() {
    return cards.size();
  }

  /**
   * Returns card randomly dealt.
   *
   * @return value.
   */
  public int dealt() {
    return dealt.size();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

  /**
   * Sorts playing cards and compares themselves to each other.
   * @return {@link Card} value.
   */
  // if true, brings them together before sorting.
  public void sort(boolean gather) {
    // If true, executes method.
    if (gather) {
      gather();
    }
    // Asks cards to compare themselves to each other.
      cards.sort(null);
  }

}

