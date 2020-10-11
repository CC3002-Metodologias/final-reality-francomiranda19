package com.github.francomiranda19.finalreality.model.character.player;

import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Weapon;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends AbstractMage {
  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   * @param lifePoints     the character's life points
   * @param defense        the character's defense
   */
  public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass, int lifePoints, int defense, int mana) {
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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WhiteMage)) {
      return false;
    }
    final WhiteMage whiteMage = (WhiteMage) o;
    return getName().equals(whiteMage.getName())
            && getCharacterClass() == whiteMage.getCharacterClass()
            && getLifePoints() == whiteMage.getLifePoints()
            && getDefense() == whiteMage.getDefense()
            && getMana() == whiteMage.getMana();
  }

  @Override
  public int hashCode() { return Objects.hash(getName(), getCharacterClass(), getLifePoints(), getDefense(), getMana()); }

}
