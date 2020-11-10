package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.classes.BlackMage;
import com.github.francomiranda19.finalreality.model.character.player.classes.WhiteMage;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code WhiteMage} class.
 *
 * @author Franco Miranda Oyarzún
 * @see WhiteMage
 */
public class WhiteMageTest extends AbstractCharacterTest {
  private static final String WHITE_MAGE_NAME = "Test White Mage";
  private WhiteMage testWhiteMage, testDefensiveWhiteMage, testDeadWhiteMage;
  private Enemy testEnemy, testDeadEnemy;
  private Knife testKnife;
  private Axe testAxe;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, LIFE, DEFENSE, MANA);
    testDefensiveWhiteMage = new WhiteMage("Test Defensive White Mage", turns, LIFE, 80, MANA);
    testDeadWhiteMage = new WhiteMage("Test Dead White Mage", turns, 0, DEFENSE, MANA);
    testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    testDeadEnemy = new Enemy("Test Dead Enemy", 10, turns, 0, DEFENSE, 15);
    testKnife = new Knife("Test Knife", 20, 10);
    testAxe = new Axe("Test Axe", 15, 10);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, LIFE, DEFENSE, MANA);
    var otherWeaponWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, LIFE, DEFENSE, MANA);
    var notExpectedWhiteMage1 = new WhiteMage("Not White Mage", turns, LIFE, DEFENSE, MANA);
    var notExpectedWhiteMage2 = new WhiteMage(WHITE_MAGE_NAME, turns, LIFE + 1, DEFENSE, MANA);
    var notExpectedWhiteMage3 = new WhiteMage(WHITE_MAGE_NAME, turns, LIFE, DEFENSE + 1, MANA);
    var notExpectedWhiteMage4 = new WhiteMage(WHITE_MAGE_NAME, turns, LIFE, DEFENSE, MANA + 1);

    assertEquals(testWhiteMage, testWhiteMage);
    assertEquals(expectedWhiteMage, testWhiteMage);
    assertEquals(expectedWhiteMage.hashCode(),testWhiteMage.hashCode());
    otherWeaponWhiteMage.equipKnife(testKnife);
    assertNotEquals(otherWeaponWhiteMage, testWhiteMage);
    assertNotEquals(otherWeaponWhiteMage.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage1, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage1.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage2, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage2.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage3, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage3.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(notExpectedWhiteMage4, testWhiteMage);
    assertNotEquals(notExpectedWhiteMage4.hashCode(), testWhiteMage.hashCode());
    assertNotEquals(testWhiteMage, new BlackMage("Not White Mage", turns, LIFE, DEFENSE, MANA));
  }

  /**
   * Checks if the white mage equips a Knife.
   */
  @Test
  void equipKnifeTest() {
    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equipKnife(testKnife);
    assertEquals(testKnife, testWhiteMage.getEquippedWeapon());
    assertNotEquals(testAxe, testWhiteMage.getEquippedWeapon());

    testDeadWhiteMage.equipKnife(testKnife);
    assertNull(testDeadWhiteMage.getEquippedWeapon());
  }

  /**
   * Checks if the attacks from an enemy to a white mage are correct.
   */
  @Test
  void attackTest() {
    assertEquals(100, testDefensiveWhiteMage.getCurrentLife());
    testEnemy.attack(testDefensiveWhiteMage);
    assertEquals(100, testDefensiveWhiteMage.getCurrentLife());

    assertEquals(100, testWhiteMage.getCurrentLife());
    testEnemy.attack(testWhiteMage);
    assertEquals(95, testWhiteMage.getCurrentLife());

    testDeadEnemy.attack(testWhiteMage);
    assertEquals(95, testWhiteMage.getCurrentLife());
  }
}
