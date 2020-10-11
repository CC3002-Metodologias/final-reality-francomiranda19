package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.Weapon;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Engineer extends PlayerCharacter {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param lifePoints     the character's life points
   * @param defense        the character's defense
   */
  public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass,
                  int lifePoints, int defense) {
    super(name, turnsQueue, characterClass, lifePoints, defense);
  }

  /**
   * Equips an axe to this character.
   *
   * @param axe the character will equip this weapon
   */
  public void equipAxe(Weapon axe) {
    this.equippedWeapon = axe;
  }

  /**
   * Equips a bow to this character.
   *
   * @param bow the character will equip this weapon
   */
  public void equipBow(Weapon bow) {
    this.equippedWeapon = bow;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Engineer)) {
      return false;
    }
    final Engineer engineer = (Engineer) o;
    return getName().equals(engineer.getName())
            && getCharacterClass() == engineer.getCharacterClass()
            && getLifePoints() == engineer.getLifePoints()
            && getDefense() == engineer.getDefense();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCharacterClass(), getLifePoints(), getDefense());
  }

}
