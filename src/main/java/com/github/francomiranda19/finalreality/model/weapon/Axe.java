package com.github.francomiranda19.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of an Axe.
 *
 * @author Franco Miranda Oyarzún
 */
public class Axe extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   */
  public Axe(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  /**
   * Checks if two Axes are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof Axe && super.equals(o);
  }

  /**
   * Hash function of the Axe.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), Axe.class);
  }
}
