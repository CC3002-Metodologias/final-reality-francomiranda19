package com.github.francomiranda19.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.weapon.Weapon;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();

  /**
   * Returns this character's class.
   */
  CharacterClass getCharacterClass();

  /**
   * Returns this character's maximum life.
   */
  int getMaxLife();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Returns this characters current life.
   */
  int getCurrentLife();

  /**
   * Updates this character's current life when it receives damage.
   *
   * @param attack attack of the attacking character
   * @param defense defense of the attacked character
   */
  void receiveDamage(int attack, int defense);

}
