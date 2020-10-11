package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.BlackMage;
import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.character.player.WhiteMage;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Weapon;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WhiteMageTest extends PlayerCharacterTest {
  private static final String WHITE_MAGE_NAME = "Test White Mage";
  private WhiteMage testWhiteMage;
  private Knife testKnife;
  private Axe testAxe;

  @BeforeEach
  void setUp() {
    testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE, MANA);
    testKnife = new Knife("Test Knife", 20, 10, WeaponType.KNIFE);
    testAxe = new Axe("Test Axe", 15, 10, WeaponType.AXE);
  }

  @Test
  void constructorTest() {
    var expectedWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE, MANA);
    var notExpectedWhiteMage1 = new WhiteMage("Not White Mage", turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE, MANA);
    var notExpectedWhiteMage2 = new WhiteMage(WHITE_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA);
    var notExpectedWhiteMage3 = new WhiteMage(WHITE_MAGE_NAME, turns, CharacterClass.WHITE_MAGE, LIFE + 1, DEFENSE, MANA);
    var notExpectedWhiteMage4 = new WhiteMage(WHITE_MAGE_NAME, turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE + 1, MANA);
    var notExpectedWhiteMage5 = new WhiteMage(WHITE_MAGE_NAME, turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE, MANA + 1);

    assertEquals(testWhiteMage, testWhiteMage);
    assertEquals(expectedWhiteMage, testWhiteMage);
    assertEquals(expectedWhiteMage.hashCode(),testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage1, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage1.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage2, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage2.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage3, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage3.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage4, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage4.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage5, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage5.hashCode(), testWhiteMage.hashCode());
    assertFalse(testWhiteMage.equals(new BlackMage("Not White Mage", turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA)));
  }

  @Test
  void equipKnifeTest() {
    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equipKnife(testKnife);
    assertEquals(testKnife, testWhiteMage.getEquippedWeapon());
    assertNotEquals(testAxe, testWhiteMage.getEquippedWeapon());
  }

}
