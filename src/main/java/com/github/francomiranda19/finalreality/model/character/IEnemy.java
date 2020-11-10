package com.github.francomiranda19.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.AbstractPlayerCharacter;

/**
 * This represents an enemy from the game.
 * An enemy is controlled by the CPU.
 *
 * @author Franco Miranda Oyarzún
 */
public interface IEnemy {

  /**
   * Decreases the player character's life.
   * @param playerCharacter who is going to be attacked.
   */
  void attack(AbstractPlayerCharacter playerCharacter);
}
