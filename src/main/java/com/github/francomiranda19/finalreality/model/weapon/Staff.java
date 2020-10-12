package com.github.francomiranda19.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a Staff.
 *
 * @author Franco Miranda Oyarzún
 */
public class Staff extends Weapon {
  private final int magicDamage;

  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   * @param type This weapon's type.
   * @see WeaponType
   */
  public Staff(String name, int damage, int weight, WeaponType type, int magicDamage) {
    super(name, damage, weight, type);
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
    if (this == o) {
      return true;
    }
    if (!(o instanceof Staff)) {
      return false;
    }
    final Staff staff = (Staff) o;
    return getName().equals(staff.getName())
            && getDamage() == staff.getDamage()
            && getWeight() == staff.getWeight()
            && getWeaponType() == staff.getWeaponType()
            && getMagicDamage() == staff.getMagicDamage();
  }

  /**
   * Hash funciton of the Staff.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getWeaponType(), getMagicDamage());
  }

}
