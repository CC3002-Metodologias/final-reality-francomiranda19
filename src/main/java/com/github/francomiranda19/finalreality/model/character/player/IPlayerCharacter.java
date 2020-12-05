package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.weapon.*;

/**
 * This represents a character from the game.
 * A character is controlled by the player.
 *
 * @author Franco Miranda Oyarzún
 */
public interface IPlayerCharacter extends ICharacter {

  /**
   * Returns this character's equipped weapon.
   */
  IWeapon getEquippedWeapon();

  /**
   * Decreases the enemy's life.
   * @param enemy who is going to be attacked.
   */
  void attack(IEnemy enemy);

  /**
   * Tries to equip a weapon.
   * @param weapon that will eventually be equipped
   */
  void equip(IWeapon weapon);

  /**
   * Tries to equip an axe.
   * @param axe that will eventually be equipped
   */
  void equipAxe(Axe axe);

  /**
   * Tries to equip a bow.
   * @param bow that will eventually be equipped
   */
  void equipBow(Bow bow);

  /**
   * Tries to equip a knife.
   * @param knife that will eventually be equipped
   */
  void equipKnife(Knife knife);

  /**
   * Tries to equip a staff.
   * @param staff that will eventually be equipped
   */
  void equipStaff(Staff staff);

  /**
   * Tries to equip a sword.
   * @param sword that will eventually be equipped
   */
  void equipSword(Sword sword);
}
