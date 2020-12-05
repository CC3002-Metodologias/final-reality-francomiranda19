package com.github.francomiranda19.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;

import java.util.Objects;

/**
 * A class that holds all the information of a Bow.
 *
 * @author Franco Miranda Oyarzún
 */
public class Bow extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name.
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   */
  public Bow(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equipTo(IPlayerCharacter character) {
    character.equipBow(this);
  }

  /**
   * Checks if two Bows are equal.
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof Bow && super.equals(o);
  }

  /**
   * Hash function of the Bow.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), Bow.class);
  }
}
