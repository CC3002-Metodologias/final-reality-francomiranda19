package com.github.francomiranda19.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.francomiranda19.finalreality.model.character.player.PlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Franco Miranda Oyarzún
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int attack;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight,
      @NotNull final BlockingQueue<ICharacter> turnsQueue, int maxLife, int defense, int attack) {
    super(turnsQueue, name, CharacterClass.ENEMY, maxLife, defense);
    this.weight = weight;
    this.attack = attack;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the attack of this enemy.
   */
  public int getAttack() { return attack; }

  /**
   * Decreases the player character's life.
   *
   * @param playerCharacter who is going to be attacked
   */
  public void attack(PlayerCharacter playerCharacter) {
    if (this.getCurrentLife() > 0) {
      playerCharacter.receiveDamage(this.getAttack(), playerCharacter.getDefense());
    }
  }

  /**
   * Checks if two enemies are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getName().equals(enemy.getName())
            && getWeight() == enemy.getWeight()
            && getMaxLife() == enemy.getMaxLife()
            && getDefense() == enemy.getDefense()
            && getAttack() == enemy.getAttack();
  }

  /**
   * Hash function of the enemy.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getWeight(), getMaxLife(), getDefense(), getAttack());
  }

  @Override
  public void waitTurn() {
    var enemy = (Enemy) this;
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

}
