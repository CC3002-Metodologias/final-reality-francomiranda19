package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Thief extends PlayerCharacter {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param lifePoints     the character's life points
   * @param defense        the character's defense
   */
  public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass, int lifePoints, int defense) {
    super(name, turnsQueue, characterClass, lifePoints, defense);
  }

  /**
   * Equips a sword to this character.
   *
   * @param sword the character will equip this weapon
   */
  public void equipSword(Weapon sword) {
    this.equippedWeapon = sword;
  }

  /**
   * Equips a staff to this character.
   *
   * @param staff the character will equip this weapon
   */
  public void equipStaff(Weapon staff) {
    this.equippedWeapon = staff;
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
    if (!(o instanceof Thief)) {
      return false;
    }
    final Thief thief = (Thief) o;
    return getName().equals(thief.getName())
            && getCharacterClass() == thief.getCharacterClass()
            && getLifePoints() == thief.getLifePoints()
            && getDefense() == thief.getDefense()
            && getEquippedWeapon() == thief.getEquippedWeapon();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCharacterClass(), getLifePoints(), getDefense(), getEquippedWeapon());
  }

}
