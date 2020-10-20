package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.AbstractCharacter;
import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 */
public class PlayerCharacter extends AbstractCharacter {

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   * @param maxLife
   *     the character's maximum life
   * @param defense
   *     the character's defense
   */
  public PlayerCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, final CharacterClass characterClass,
                         int maxLife, int defense) {
    super(turnsQueue, name, characterClass, maxLife, defense);
  }

  /**
   * Decreases the enemy's life.
   *
   * @param enemy who is going to be attacked.
   */
  public void attack(Enemy enemy) {
    if (this.getCurrentLife() > 0 && this.getEquippedWeapon() != null) {
      enemy.receiveDamage(this.getEquippedWeapon().getDamage(), enemy.getDefense());
    }
  }

  /**
   * Checks if two Player Characters are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter playerCharacter = (PlayerCharacter) o;
    return getName().equals(playerCharacter.getName())
            && getCharacterClass() == playerCharacter.getCharacterClass()
            && getMaxLife() == playerCharacter.getMaxLife()
            && getDefense() == playerCharacter.getDefense();
  }

  /**
   * Hash function of the Player Character.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCharacterClass(), getMaxLife(), getDefense());
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

}
