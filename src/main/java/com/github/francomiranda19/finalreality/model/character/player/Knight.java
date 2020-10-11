package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param lifePoints     the character's life points
   * @param defense        the character's defense
   */
  public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass,
                int lifePoints, int defense) {
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
   * Equips an axe to this character.
   *
   * @param axe the character will equip this weapon
   */
  public void equipAxe(Weapon axe) {
    this.equippedWeapon = axe;
  }

  /**
   * Equips a knife to this character.
   *
   * @param knife the character will equip this weapon
   */
  public void equipKnife(Weapon knife) {
    this.equippedWeapon = knife;
  }

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
            && getLifePoints() == knight.getLifePoints()
            && getDefense() == knight.getDefense();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCharacterClass(), getLifePoints(), getDefense());
  }

}
