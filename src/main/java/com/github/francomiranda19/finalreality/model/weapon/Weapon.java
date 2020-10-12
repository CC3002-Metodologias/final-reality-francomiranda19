package com.github.francomiranda19.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 */
public class Weapon implements IWeapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final WeaponType weaponType;

  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @see WeaponType
   */
  public Weapon(final String name, final int damage, final int weight, final WeaponType weaponType) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.weaponType = weaponType;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public WeaponType getWeaponType() {
    return weaponType;
  }

  /**
   * Checks if two Weapons are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon weapon = (Weapon) o;
    return getName().equals(weapon.getName())
            && getDamage() == weapon.getDamage()
            && getWeight() == weapon.getWeight()
            && getWeaponType() == weapon.getWeaponType();
  }

  /**
   * Hash function of the weapon.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getWeaponType());
  }
}
