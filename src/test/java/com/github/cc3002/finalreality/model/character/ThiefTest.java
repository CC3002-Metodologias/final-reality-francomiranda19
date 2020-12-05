package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.classes.Knight;
import com.github.francomiranda19.finalreality.model.character.player.classes.Thief;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.Staff;
import com.github.francomiranda19.finalreality.model.weapon.Sword;
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
public class ThiefTest extends AbstractCharacterTest {
  private static final String THIEF_NAME = "Test Thief";
  private Thief testThief, testDefensiveThief, testDeadThief;
  private Enemy testEnemy, testDeadEnemy;
  private Sword testSword;
  private Staff testStaff;
  private Bow testBow;
  private Axe testAxe;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testThief = new Thief(THIEF_NAME, turns, LIFE, DEFENSE);
    testDefensiveThief = new Thief("Test Defensive Thief", turns, LIFE, 80);
    testDeadThief = new Thief("Test Dead Thief", turns, 0, DEFENSE);
    testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    testDeadEnemy = new Enemy("Test Dead Enemy", 10, turns, 0, DEFENSE, 15);
    testSword = new Sword("Test Sword", 15, 10);
    testStaff = new Staff("Test Staff", 20, 10, 20);
    testBow = new Bow("Test Bow", 15, 10);
    testAxe = new Axe("Test Axe", 10, 10);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedThief = new Thief(THIEF_NAME, turns, LIFE, DEFENSE);
    var otherWeaponThief = new Thief(THIEF_NAME, turns, LIFE, DEFENSE);
    var notExpectedThief1 = new Thief("Not Thief", turns, LIFE, DEFENSE);
    var notExpectedThief2 = new Thief(THIEF_NAME, turns, LIFE + 1, DEFENSE);
    var notExpectedThief3 = new Thief(THIEF_NAME, turns, LIFE, DEFENSE + 1);

    assertEquals(testThief, testThief);
    assertEquals(expectedThief, testThief);
    assertEquals(expectedThief.hashCode(),testThief.hashCode());
    otherWeaponThief.equip(testBow);
    assertNotEquals(otherWeaponThief, testThief);
    assertNotEquals(otherWeaponThief.hashCode(), testThief.hashCode());
    assertNotEquals(notExpectedThief1, testThief);
    assertNotEquals(notExpectedThief1.hashCode(), testThief.hashCode());
    assertNotEquals(notExpectedThief2, testThief);
    assertNotEquals(notExpectedThief2.hashCode(), testThief.hashCode());
    assertNotEquals(notExpectedThief3, testThief);
    assertNotEquals(notExpectedThief3.hashCode(), testThief.hashCode());
    assertNotEquals(testThief, new Knight("Not Thief", turns, LIFE, DEFENSE));
  }

  /**
   * Checks if the black mage equips its corresponding weapons.
   */
  @Test
  void equipWeaponTest() {
    assertNull(testThief.getEquippedWeapon());
    testThief.equip(testSword);
    assertEquals(testSword, testThief.getEquippedWeapon());
    assertNotEquals(testStaff, testThief.getEquippedWeapon());
    assertNotEquals(testBow, testThief.getEquippedWeapon());

    testThief.equip(testStaff);
    assertEquals(testStaff, testThief.getEquippedWeapon());
    assertNotEquals(testSword, testThief.getEquippedWeapon());
    assertNotEquals(testBow, testThief.getEquippedWeapon());

    testThief.equip(testBow);
    assertEquals(testBow, testThief.getEquippedWeapon());
    assertNotEquals(testSword, testThief.getEquippedWeapon());
    assertNotEquals(testStaff, testThief.getEquippedWeapon());

    testThief.equip(testAxe);
    assertEquals(testBow, testThief.getEquippedWeapon());
    assertNotEquals(testSword, testThief.getEquippedWeapon());

    testDeadThief.equip(testSword);
    assertNull(testDeadThief.getEquippedWeapon());
    testDeadThief.equip(testStaff);
    assertNull(testDeadThief.getEquippedWeapon());
    testDeadThief.equip(testBow);
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
