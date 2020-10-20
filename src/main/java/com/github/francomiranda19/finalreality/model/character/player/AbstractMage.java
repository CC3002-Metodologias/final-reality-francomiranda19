package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single mage of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class AbstractMage extends PlayerCharacter {
  private int mana;

  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public AbstractMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass,
                      int maxLife, int defense, int mana) {
    super(name, turnsQueue, characterClass, maxLife, defense);
    this.mana = mana;
  }

  /**
   * Returns this mages' mana.
   */
  public int getMana() { return mana; }

}
