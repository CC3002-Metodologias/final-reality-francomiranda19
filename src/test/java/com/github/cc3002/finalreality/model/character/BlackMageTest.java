package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.classes.BlackMage;
import com.github.francomiranda19.finalreality.model.character.player.classes.WhiteMage;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code BlackMage} class.
 *
 * @author Franco Miranda Oyarzún
 * @see BlackMage
 */
public class BlackMageTest extends AbstractCharacterTest {
  private static final String BLACK_MAGE_NAME = "Test Black Mage";
  private BlackMage testBlackMage, testDefensiveBlackMage, testDeadBlackMage;
  private Enemy testEnemy, testDeadEnemy;
  private Knife testKnife;
  private Staff testStaff;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA);
    testDefensiveBlackMage = new BlackMage("Test Defensive Black Mage", turns, LIFE, 80, MANA);
    testDeadBlackMage = new BlackMage("Test Dead Black Mage", turns, 0, DEFENSE, MANA);
    testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    testDeadEnemy = new Enemy("Test Dead Enemy", 10, turns, 0, DEFENSE, 15);
    testKnife = new Knife("Test Knife", 15, 10);
    testStaff = new Staff("Test Staff", 20, 10, 30);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA);
    var otherWeaponBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA);
    var notExpectedBlackMage1 = new BlackMage("Not Black Mage", turns, LIFE, DEFENSE, MANA);
    var notExpectedBlackMage2 = new BlackMage(BLACK_MAGE_NAME, turns, LIFE + 1, DEFENSE, MANA);
    var notExpectedBlackMage3 = new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE + 1, MANA);
    var notExpectedBlackMage4 = new BlackMage(BLACK_MAGE_NAME, turns, LIFE, DEFENSE, MANA + 1);

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
    assertNotEquals(testBlackMage, new WhiteMage("Not Black Mage", turns, LIFE, DEFENSE, MANA));
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

    testDeadBlackMage.equipKnife(testKnife);
    assertNull(testDeadBlackMage.getEquippedWeapon());
  }

  /**
   * Checks if the black mage equips a Staff.
   */
  @Test
  void equipStaffTest() {
    testBlackMage.equipStaff(testStaff);
    assertEquals(testStaff, testBlackMage.getEquippedWeapon());
    assertNotEquals(testKnife, testBlackMage.getEquippedWeapon());

    testDeadBlackMage.equipStaff(testStaff);
    assertNull(testDeadBlackMage.getEquippedWeapon());
  }

  /**
   * Checks if the attacks from an enemy to a black mage are correct.
   */
  @Test
  void attackTest() {
    assertEquals(100, testDefensiveBlackMage.getCurrentLife());
    testEnemy.attack(testDefensiveBlackMage);
    assertEquals(100, testDefensiveBlackMage.getCurrentLife());

    assertEquals(100, testBlackMage.getCurrentLife());
    testEnemy.attack(testBlackMage);
    assertEquals(95, testBlackMage.getCurrentLife());
    
    testDeadEnemy.attack(testBlackMage);
    assertEquals(95, testBlackMage.getCurrentLife());
  }

}
