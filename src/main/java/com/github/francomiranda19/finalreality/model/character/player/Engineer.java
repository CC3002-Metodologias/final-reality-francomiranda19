package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.Weapon;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

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
  public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass, int lifePoints, int defense) {
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

}
