package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single black mage of the game.
 *
 * @author Franco Miranda Oyarzún
 */
public class BlackMage extends AbstractMage{
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param maxLife        the character's maximum life
   * @param defense        the character's defense
   */
  public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass,
                   int maxLife, int defense, int mana) {
    super(name, turnsQueue, characterClass, maxLife, defense, mana);
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
   * Checks if two Black Mages are equal.
   *
   * @param o to check object.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BlackMage)) {
      return false;
    }
    final BlackMage blackMage = (BlackMage) o;
    return getName().equals(blackMage.getName())
            && getCharacterClass() == blackMage.getCharacterClass()
            && getMaxLife() == blackMage.getMaxLife()
            && getDefense() == blackMage.getDefense()
            && getMana() == blackMage.getMana()
            && getEquippedWeapon() == blackMage.getEquippedWeapon();
  }

  /**
   * Hash function of the black mage.
   */
  @Override
  public int hashCode() { return Objects.hash(getName(), getCharacterClass(), getMaxLife(), getDefense(), getMana(), getEquippedWeapon()); }

}
