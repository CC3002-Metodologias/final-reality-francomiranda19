package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.player.BlackMage;
import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.character.player.WhiteMage;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code BlackMage} class.
 *
 * @author Franco Miranda Oyarzún
 * @see BlackMage
 */
public class BlackMageTest extends PlayerCharacterTest {
  private static final String BLACK_MAGE_NAME = "Test Black Mage";
  private BlackMage testBlackMage;
  private Knife testKnife;
  private Staff testStaff;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA);
    testKnife = new Knife("Test Knife", 15, 10, WeaponType.KNIFE);
    testStaff = new Staff("Test Staff", 20, 10, WeaponType.STAFF, 30);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA);
    var otherWeaponBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA);
    var notExpectedBlackMage1 = new BlackMage("Not Black Mage", turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA);
    var notExpectedBlackMage2 = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE, MANA);
    var notExpectedBlackMage3 = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE + 1, DEFENSE, MANA);
    var notExpectedBlackMage4 = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE + 1, MANA);
    var notExpectedBlackMage5 = new BlackMage(BLACK_MAGE_NAME, turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE, MANA + 1);

    assertEquals(testBlackMage, testBlackMage);
    assertEquals(expectedBlackMage, testBlackMage);
    assertEquals(expectedBlackMage.hashCode(),testBlackMage.hashCode());
    otherWeaponBlackMage.equipKnife(testKnife);
    assertNotEquals(otherWeaponBlackMage, testBlackMage);
    assertNotEquals(otherWeaponBlackMage.hashCode(), testBlackMage.hashCode());
    assertNotEquals(notExpectedBlackMage1, testBlackMage);
    assertNotEquals(notExpectedBlackMage1.hashCode(), testBlackMage.hashCode());
    assertNotEquals(notExpectedBlackMage2, testBlackMage);
    assertNotEquals(notExpectedBlackMage2.hashCode(), testBlackMage.hashCode());
    assertNotEquals(notExpectedBlackMage3, testBlackMage);
    assertNotEquals(notExpectedBlackMage3.hashCode(), testBlackMage.hashCode());
    assertNotEquals(notExpectedBlackMage4, testBlackMage);
    assertNotEquals(notExpectedBlackMage4.hashCode(), testBlackMage.hashCode());
    assertNotEquals(notExpectedBlackMage5, testBlackMage);
    assertNotEquals(notExpectedBlackMage5.hashCode(), testBlackMage.hashCode());
    assertFalse(testBlackMage.equals(new WhiteMage("Not Black Mage", turns, CharacterClass.WHITE_MAGE, LIFE, DEFENSE, MANA)));
  }

  /**
   * Checks if the black mage equips a Knife.
   */
  @Test
  void equipKnifeTest() {
    assertNull(testBlackMage.getEquippedWeapon());
    testBlackMage.equipKnife(testKnife);
    assertEquals(testKnife, testBlackMage.getEquippedWeapon());
    assertNotEquals(testStaff, testBlackMage.getEquippedWeapon());
  }

  /**
   * Checks if the black mage equips a Staff.
   */
  @Test
  void equipStaffTest() {
    testBlackMage.equipStaff(testStaff);
    assertEquals(testStaff, testBlackMage.getEquippedWeapon());
    assertNotEquals(testKnife, testBlackMage.getEquippedWeapon());
  }

  /**
   * Checks if the mana of the black mage is correct.
   */
  @Test
  void manaTest() {
    assertEquals(MANA, testBlackMage.getMana());
    assertNotEquals(MANA + 2, testBlackMage.getMana());
  }

}
