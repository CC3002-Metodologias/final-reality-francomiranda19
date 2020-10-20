package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.*;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import com.github.francomiranda19.finalreality.model.weapon.Sword;
import com.github.francomiranda19.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Set of tests for the {@code Thief} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Thief
 */
public class ThiefTest extends PlayerCharacterTest {
  private static final String THIEF_NAME = "Test Thief";
  private Thief testThief, testDefensiveThief, testDeadThief;
  private Enemy testEnemy, testDeadEnemy;
  private Sword testSword;
  private Staff testStaff;
  private Bow testBow;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testThief = new Thief(THIEF_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE);
    testDefensiveThief = new Thief("Test Defensive Thief", turns, CharacterClass.THIEF, LIFE, 80);
    testDeadThief = new Thief("Test Dead Thief", turns, CharacterClass.THIEF, 0, DEFENSE);
    testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    testDeadEnemy = new Enemy("Test Dead Enemy", 10, turns, 0, DEFENSE, 15);
    testSword = new Sword("Test Sword", 15, 10, WeaponType.SWORD);
    testStaff = new Staff("Test Staff", 20, 10, WeaponType.STAFF, 20);
    testBow = new Bow("Test Bow", 15, 10, WeaponType.BOW);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedThief = new Thief(THIEF_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE);
    var otherWeaponThief = new Thief(THIEF_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE);
    var notExpectedThief1 = new Thief("Not Thief", turns, CharacterClass.BLACK_MAGE, LIFE, DEFENSE);
    var notExpectedThief2 = new Thief(THIEF_NAME, turns, CharacterClass.KNIGHT, LIFE, DEFENSE);
    var notExpectedThief3 = new Thief(THIEF_NAME, turns, CharacterClass.THIEF, LIFE + 1, DEFENSE);
    var notExpectedThief4 = new Thief(THIEF_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE + 1);

    assertEquals(testThief, testThief);
    assertEquals(expectedThief, testThief);
    assertEquals(expectedThief.hashCode(),testThief.hashCode());
    otherWeaponThief.equipBow(testBow);
    assertNotEquals(otherWeaponThief, testThief);
    assertNotEquals(otherWeaponThief.hashCode(), testThief.hashCode());
    assertNotEquals(notExpectedThief1, testThief);
    assertNotEquals(notExpectedThief1.hashCode(), testThief.hashCode());
    assertNotEquals(notExpectedThief2, testThief);
    assertNotEquals(notExpectedThief2.hashCode(), testThief.hashCode());
    assertNotEquals(notExpectedThief3, testThief);
    assertNotEquals(notExpectedThief3.hashCode(), testThief.hashCode());
    assertNotEquals(notExpectedThief4, testThief);
    assertNotEquals(notExpectedThief4.hashCode(), testThief.hashCode());
    assertNotEquals(testThief, new Knight("Not Thief", turns, CharacterClass.KNIGHT, LIFE, DEFENSE));
  }

  /**
   * Checks if the thief equips a Sword.
   */
  @Test
  void equipSwordTest() {
    assertNull(testThief.getEquippedWeapon());
    testThief.equipSword(testSword);
    assertEquals(testSword, testThief.getEquippedWeapon());
    assertNotEquals(testStaff, testThief.getEquippedWeapon());
    assertNotEquals(testBow, testThief.getEquippedWeapon());

    testDeadThief.equipSword(testSword);
    assertNull(testDeadThief.getEquippedWeapon());
  }

  /**
   * Checks if the thief equips a Staff.
   */
  @Test
  void equipStaffTest() {
    testThief.equipStaff(testStaff);
    assertEquals(testStaff, testThief.getEquippedWeapon());
    assertNotEquals(testSword, testThief.getEquippedWeapon());
    assertNotEquals(testBow, testThief.getEquippedWeapon());

    testDeadThief.equipStaff(testStaff);
    assertNull(testDeadThief.getEquippedWeapon());
  }

  /**
   * Checks if the thief equips a Bow.
   */
  @Test
  void equipBowTest() {
    testThief.equipBow(testBow);
    assertEquals(testBow, testThief.getEquippedWeapon());
    assertNotEquals(testSword, testThief.getEquippedWeapon());
    assertNotEquals(testStaff, testThief.getEquippedWeapon());

    testDeadThief.equipBow(testBow);
    assertNull(testDeadThief.getEquippedWeapon());
  }

  /**
   * Checks if the attacks from an enemy to a thief are correct.
   */
  @Test
  void attackTest() {
    assertEquals(100, testDefensiveThief.getCurrentLife());
    testEnemy.attack(testDefensiveThief);
    assertEquals(100, testDefensiveThief.getCurrentLife());

    assertEquals(100, testThief.getCurrentLife());
    testEnemy.attack(testThief);
    assertEquals(95, testThief.getCurrentLife());

    testDeadEnemy.attack(testThief);
    assertEquals(95, testThief.getCurrentLife());
  }
}
