package com.github.francomiranda19.finalreality.model.weapon;

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

  public int getMagicDamage() { return magicDamage; }

}
