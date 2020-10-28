package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single knight of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class Knight extends PlayerCharacter {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass,
                int maxLife, int defense) {
    super(name, turnsQueue, characterClass, maxLife, defense);
  }

  /**
   * Equips a sword to this character.
   *
   * @param sword the character will equip this weapon
   */
  public void equipSword(Sword sword) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = sword;
    }
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
   * Equips a knife to this character.
   *
   * @param knife the character will equip this weapon
   */
  public void equipKnife(Knife knife) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = knife;
    }
  }

  /**
   * Checks if two Knights are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Knight)) {
      return false;
    }
    final Knight knight = (Knight) o;
    return getName().equals(knight.getName())
            && getCharacterClass() == knight.getCharacterClass()
            && getMaxLife() == knight.getMaxLife()
            && getDefense() == knight.getDefense()
            && getEquippedWeapon() == knight.getEquippedWeapon();
  }

  /**
   * Hash function of the Knight.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCharacterClass(), getMaxLife(), getDefense(), getEquippedWeapon());
  }

}
