package com.github.francomiranda19.finalreality.model.character.player.classes;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single engineer of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class Engineer extends AbstractPlayerCharacter {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int maxLife, int defense) {
    super(name, turnsQueue, maxLife, defense);
  }

  @Override
  public void equipAxe(Axe axe) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = axe;
    }
  }

  @Override
  public void equipBow(Bow bow) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = bow;
    }
  }

  @Override
  public void equipKnife(Knife knife) {

  }

  @Override
  public void equipStaff(Staff staff) {

  }

  @Override
  public void equipSword(Sword sword) {

  }

  /**
   * Checks if two Engineers are equal.
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof Engineer && super.equals(o);
  }

  /**
   * Hash function of the engineer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), Engineer.class);
  }

}
