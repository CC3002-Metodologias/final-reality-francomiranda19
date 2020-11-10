package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.weapon.IWeapon;

/**
 * This represents a character from the game.
 * A character is controlled by the player.
 *
 * @author Franco Miranda Oyarzún
 */
public interface IPlayerCharacter {

  /**
   * Returns this character's equipped weapon.
   */
  IWeapon getEquippedWeapon();

  /**
   * Decreases the enemy's life.
   * @param enemy who is going to be attacked.
   */
  void attack(Enemy enemy);
}
