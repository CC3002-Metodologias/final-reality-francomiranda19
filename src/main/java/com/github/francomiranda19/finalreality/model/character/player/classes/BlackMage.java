package com.github.francomiranda19.finalreality.model.character.player.classes;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.player.AbstractMage;
import com.github.francomiranda19.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single black mage of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class BlackMage extends AbstractMage {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                   int maxLife, int defense, int mana) {
    super(name, turnsQueue, maxLife, defense, mana);
  }

  @Override
  public void equipAxe(Axe axe) {

  }

  @Override
  public void equipBow(Bow bow) {

  }
  @Override
  public void equipKnife(Knife knife) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = knife;
    }
  }

  @Override
  public void equipStaff(Staff staff) {
    if (this.getCurrentLife() > 0) {
      this.equippedWeapon = staff;
    }
  }

  @Override
  public void equipSword(Sword sword) {

  }

  /**
   * Checks if two Black Mages are equal.
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    return o instanceof BlackMage && getMana() == ((BlackMage) o).getMana() && super.equals(o);
  }

  /**
   * Hash function of the black mage.
   */
  @Override
  public int hashCode() { return Objects.hash(super.hashCode(), getMana(), Staff.class); }

}
