package com.github.francomiranda19.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a Staff.
 *
 * @author Franco Miranda Oyarzún
 */
public class Staff extends AbstractWeapon {
  private final int magicDamage;

  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   */
  public Staff(String name, int damage, int weight, int magicDamage) {
    super(name, damage, weight);
    this.magicDamage = magicDamage;
  }

  /**
   * Returns the staffs' magic damage.
   */
  public int getMagicDamage() { return magicDamage; }

  /**
   * Checks if two Staffs are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof Staff && getMagicDamage() == ((Staff) o).getMagicDamage() && super.equals(o);
  }

  /**
   * Hash function of the Staff.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getMagicDamage(), Staff.class);
  }

}
