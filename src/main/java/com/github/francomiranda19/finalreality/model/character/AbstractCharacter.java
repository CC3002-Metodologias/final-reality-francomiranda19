package com.github.francomiranda19.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.weapon.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;
  protected IWeapon equippedWeapon = null;
  protected ScheduledExecutorService scheduledExecutor;
  private final int maxLife;
  private int currentLife;
  private final int defense;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
                              @NotNull String name, CharacterClass characterClass, int maxLife, int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.maxLife = maxLife;
    this.currentLife = maxLife;
    this.defense = defense;
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() { return name; }

  @Override
  public IWeapon getEquippedWeapon() { return equippedWeapon; }

  @Override
  public CharacterClass getCharacterClass() { return characterClass; }

  @Override
  public int getMaxLife() { return maxLife; }

  @Override
  public int getDefense() { return defense; }

  @Override
  public int getCurrentLife() { return currentLife; }

  @Override
  public void receiveDamage(int attack, int defense) {
    int damage = attack - defense;
    if (damage >= 0) {
      this.currentLife -= damage;
    }
  }

}