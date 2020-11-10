package com.github.francomiranda19.finalreality.model.character.player.classes;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.player.AbstractMage;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single white mage of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class WhiteMage extends AbstractMage {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int maxLife, int defense, int mana) {
    super(name, turnsQueue, maxLife, defense, mana);
  }

  /**
   * Equips a knife to this character.
   *
   * @param knife the character will equip this weapon
   */
  public void equipKnife(Knife knife) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = knife;
    }
  }

  /**
   * Checks if two White Mages are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof WhiteMage && getMana() == ((WhiteMage) o).getMana() && super.equals(o);
  }

  /**
   * Hash function of the White Mage.
   */
  @Override
  public int hashCode() { return Objects.hash(super.hashCode(), getMana(), Staff.class); }

}
