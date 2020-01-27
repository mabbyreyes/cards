package edu.cnm.deepdive.model;

import java.util.Objects;

/**
 * Encapsulates a single playing card as a combination of {@link Suit} and {@link Rank}. Instances
 * of this class are immutable.
 *
 * @author Maritza Reyes &amp; Deep Dive Coding Java + Android Cohort 9.
 */
public class Card {

  private final Suit suit;
  private final Rank rank;
  private final int hash;

  /**
   * Initializes the Card instance with the specified {@link Suit} and {@link Rank}.
   *
   * @param suit {@link Suit} value of card.
   * @param rank {@link Rank} value of card.
   */
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash(suit, rank);
  }

  /**
   * Returns at {@link Suit} of this Card instance.
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns at {@link Rank} of this Card instance.
   */
  public Rank getRank() {
    return rank;
  }


  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean comparison = false;
    if (obj == this) {
      comparison = true;
    } else if (obj instanceof Card) {
      Card other = (Card) obj;
      if (hash == other.hash && suit == other.suit && rank == other.rank) {
        comparison = true;
      }
    }
    return comparison;
  }

}
