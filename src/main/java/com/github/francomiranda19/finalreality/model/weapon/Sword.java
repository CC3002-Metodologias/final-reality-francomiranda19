package com.github.francomiranda19.finalreality.model.weapon;

public class Sword extends Weapon {
  /**
   * Creates a weapon with a name, a base damage, weight and its type.
   *
   * @param name This weapon's name
   * @param damage This weapon's damage.
   * @param weight This weapon's weight.
   * @param type This weapon's type.
   * @see WeaponType
   */
  public Sword(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }

}
