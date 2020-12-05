package com.github.francomiranda19.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;

import java.util.Objects;

/**
 * A class that holds all the information of a Knife.
 *
 * @author Franco Miranda Oyarzún
 */
public class Knife extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name.
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   */
  public Knife(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equipTo(IPlayerCharacter character) {
    character.equipKnife(this);
  }

  /**
   * Checks if two Knifes are equal.
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof Knife && super.equals(o);
  }

  /**
   * Hash function of the Knife.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), Knife.class);
  }

}
