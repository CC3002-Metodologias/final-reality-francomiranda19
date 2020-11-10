package com.github.francomiranda19.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a Sword.
 *
 * @author Franco Miranda Oyarzún
 */
public class Sword extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   */
  public Sword(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  /**
   * Checks if two Swords are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof Sword && super.equals(o);
  }

  /**
   * Hash function of the Sword.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), Sword.class);
  }
}
