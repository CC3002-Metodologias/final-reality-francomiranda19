package com.github.francomiranda19.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.character.player.PlayerCharacter;
import com.github.francomiranda19.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
  protected Weapon equippedWeapon = null;
  protected ScheduledExecutorService scheduledExecutor;
  private final int lifePoints;
  private final int defense;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass, int lifePoints, int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.lifePoints = lifePoints;
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
  public Weapon getEquippedWeapon() { return equippedWeapon; }

  @Override
  public CharacterClass getCharacterClass() { return characterClass; }

  @Override
  public int getLifePoints() { return lifePoints; }

  @Override
  public int getDefense() { return defense; }

}