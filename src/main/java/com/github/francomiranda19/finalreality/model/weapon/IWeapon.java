package com.github.francomiranda19.finalreality.model.weapon;

import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;

/**
 * This represents a weapon from the game.
 * A weapon can be equipped only by a player character.
 *
 * @author Franco Miranda Oyarzún
 */
public interface IWeapon {

  /**
   * Returns this weapon's name.
   */
  String getName();

  /**
   * Returns this weapon's damage.
   */
  int getDamage();

  /**
   * Returns this weapon's weight.
   */
  int getWeight();

  /**
   * Tries to equip a weapon to a character
   * @param character who will eventually equip this weapon.
   */
  void equipTo(IPlayerCharacter character);
}
