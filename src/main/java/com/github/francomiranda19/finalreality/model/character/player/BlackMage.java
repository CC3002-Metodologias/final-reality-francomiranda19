package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import com.github.francomiranda19.finalreality.model.weapon.Weapon;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class BlackMage extends AbstractMage{
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param lifePoints     the character's life points
   * @param defense        the character's defense
   */
  public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass,
                   int lifePoints, int defense, int mana) {
    super(name, turnsQueue, characterClass, lifePoints, defense, mana);
  }

  /**
   * Equips a knife to this character.
   *
   * @param knife the character will equip this weapon
   */
  public void equipKnife(Weapon knife) {
    this.equippedWeapon = knife;
  }

  /**
   * Equips a staff to this character.
   *
   * @param staff the character will equip this weapon
   */
  public void equipStaff(Weapon staff) {
    this.equippedWeapon = staff;
  }

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
            && getLifePoints() == blackMage.getLifePoints()
            && getDefense() == blackMage.getDefense()
            && getMana() == blackMage.getMana();
  }

  @Override
  public int hashCode() { return Objects.hash(getName(), getCharacterClass(), getLifePoints(), getDefense(), getMana()); }

}
