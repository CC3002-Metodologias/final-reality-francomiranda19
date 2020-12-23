package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.controller.handlers.IEventHandler;
import com.github.francomiranda19.finalreality.model.character.AbstractCharacter;
import com.github.francomiranda19.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter {

  private final PropertyChangeSupport characterEndsTurnEvent;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param maxLife
   *     the character's maximum life
   * @param defense
   *     the character's defense
   */
  public AbstractPlayerCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                         int maxLife, int defense) {
    super(turnsQueue, name, maxLife, defense);
    this.characterEndsTurnEvent = new PropertyChangeSupport(this);
  }

  @Override
  public void attack(IEnemy enemy) {
    if (this.getCurrentLife() > 0) {
      enemy.receiveDamage(this.getAttack(), enemy.getDefense());
      characterEndsTurnEvent.firePropertyChange("Character attack", enemy, this);
    }
  }

  @Override
  public void equip(IWeapon weapon) {
    weapon.equipTo(this);
  }

  @Override
  public IWeapon getEquippedWeapon() { return equippedWeapon; }

  @Override
  public int getAttack() {
    if (this.getEquippedWeapon() != null) {
      return this.getEquippedWeapon().getDamage();
    }
    else {
      return 0;
    }
  }

  @Override
  public void addListener(IEventHandler handler) {
    characterEndsTurnEvent.addPropertyChangeListener(handler);
  }

  /**
   * Checks if two Player Characters are equal.
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractPlayerCharacter)) {
      return false;
    }
    final AbstractPlayerCharacter playerCharacter = (AbstractPlayerCharacter) o;
    return getName().equals(playerCharacter.getName())
            && getMaxLife() == playerCharacter.getMaxLife()
            && getDefense() == playerCharacter.getDefense()
            && getEquippedWeapon() == playerCharacter.getEquippedWeapon();
  }

  /**
   * Hash function of the Player Character.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getMaxLife(), getDefense(), getEquippedWeapon());
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (equippedWeapon != null) {
      scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);

    }
    else {
      scheduledExecutor.schedule(this::addToQueue, 0, TimeUnit.SECONDS);
    }
  }

}
