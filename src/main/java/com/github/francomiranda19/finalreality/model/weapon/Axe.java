package com.github.francomiranda19.finalreality.model.weapon;

import java.util.Objects;

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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Axe)) {
      return false;
    }
    final Axe axe = (Axe) o;
    return getName().equals(axe.getName()) &&
            getDamage() == axe.getDamage() &&
            getWeight() == axe.getWeight() &&
            getType() == axe.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}
