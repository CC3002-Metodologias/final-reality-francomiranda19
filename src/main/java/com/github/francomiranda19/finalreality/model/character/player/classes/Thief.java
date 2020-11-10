package com.github.francomiranda19.finalreality.model.character.player.classes;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single thief of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class Thief extends AbstractPlayerCharacter {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int maxLife, int defense) {
    super(name, turnsQueue, maxLife, defense);
  }

  /**
   * Equips a sword to this character.
   *
   * @param sword the character will equip this weapon
   */
  public void equipSword(Sword sword) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = sword;
    }
  }

  /**
   * Equips a staff to this character.
   *
   * @param staff the character will equip this weapon
   */
  public void equipStaff(Staff staff) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = staff;
    }
  }

  /**
   * Equips a bow to this character.
   *
   * @param bow the character will equip this weapon
   */
  public void equipBow(Bow bow) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = bow;
    }
  }

  /**
   * Checks if two Thiefs are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof Thief && super.equals(o);
  }

  /**
   * Hash function of the Thief.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), Thief.class);
  }

}
