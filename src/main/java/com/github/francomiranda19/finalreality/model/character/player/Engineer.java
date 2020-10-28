package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single engineer of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class Engineer extends PlayerCharacter {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass,
                  int maxLife, int defense) {
    super(name, turnsQueue, characterClass, maxLife, defense);
  }

  /**
   * Equips an axe to this character.
   *
   * @param axe the character will equip this weapon
   */
  public void equipAxe(Axe axe) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = axe;
    }
  }

  /**
   * Equips a bow to this character.
   *
   * @param bow the character will equip this weapon
   */
  public void equipBow(Bow bow) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = bow;
    }
  }

  /**
   * Checks if two Engineers are equal.
   *
   * @param o to check object.
   */
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
            && getMaxLife() == engineer.getMaxLife()
            && getDefense() == engineer.getDefense()
            && getEquippedWeapon() == engineer.getEquippedWeapon();
  }

  /**
   * Hash function of the engineer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCharacterClass(), getMaxLife(), getDefense(), getEquippedWeapon());
  }

}
