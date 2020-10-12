package com.github.francomiranda19.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of an Axe.
 *
 * @author Franco Miranda Oyarzún
 */
public class Axe extends Weapon {
  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   * @param type This weapon's type.
   * @see WeaponType
   */
  public Axe(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }

  /**
   * Checks if two Axes are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Axe)) {
      return false;
    }
    final Axe axe = (Axe) o;
    return getName().equals(axe.getName())
            && getDamage() == axe.getDamage()
            && getWeight() == axe.getWeight()
            && getWeaponType() == axe.getWeaponType();
  }

  /**
   * Hash function of the Axe.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getWeaponType());
  }
}
