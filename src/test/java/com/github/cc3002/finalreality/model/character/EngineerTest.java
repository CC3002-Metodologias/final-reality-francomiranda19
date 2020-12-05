package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.classes.Engineer;
import com.github.francomiranda19.finalreality.model.character.player.classes.Thief;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code Engineer} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Engineer
 */
public class EngineerTest extends AbstractCharacterTest {
  private static final String ENGINEER_NAME = "Test Engineer";
  private Engineer testEngineer, testDefensiveEngineer, testDeadEngineer;
  private Enemy testEnemy, testDeadEnemy;
  private Axe testAxe;
  private Bow testBow;
  private Knife testKnife;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testEngineer = new Engineer(ENGINEER_NAME, turns, LIFE, DEFENSE);
    testDefensiveEngineer = new Engineer("Test Defensive Engineer", turns, LIFE, 80);
    testDeadEngineer = new Engineer("Test Dead Engineer", turns, 0, DEFENSE);
    testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    testDeadEnemy = new Enemy("Test Dead Enemy", 10, turns, 0, DEFENSE, 15);
    testAxe = new Axe("Test Axe", 20, 10);
    testBow = new Bow("Test Bow", 25, 10);
    testKnife = new Knife("Test Knife", 15, 10);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedEngineer = new Engineer(ENGINEER_NAME, turns, LIFE, DEFENSE);
    var otherWeaponEngineer = new Engineer(ENGINEER_NAME, turns, LIFE, DEFENSE);
    var notExpectedEngineer1 = new Engineer("Not Engineer", turns, LIFE, DEFENSE);
    var notExpectedEngineer2 = new Engineer(ENGINEER_NAME, turns, LIFE + 1, DEFENSE);
    var notExpectedEngineer3 = new Engineer(ENGINEER_NAME, turns, LIFE, DEFENSE + 1);

    assertEquals(testEngineer, testEngineer);
    assertEquals(expectedEngineer, testEngineer);
    assertEquals(expectedEngineer.hashCode(),testEngineer.hashCode());
    otherWeaponEngineer.equip(testAxe);
    assertNotEquals(otherWeaponEngineer, testEngineer);
    assertNotEquals(otherWeaponEngineer.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer1, testEngineer);
    assertNotEquals(notExpectedEngineer1.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer2, testEngineer);
    assertNotEquals(notExpectedEngineer2.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer3, testEngineer);
    assertNotEquals(notExpectedEngineer3.hashCode(), testEngineer.hashCode());
    assertNotEquals(testEngineer, new Thief("Not Engineer", turns, LIFE, DEFENSE));
  }

  /**
   * Checks if the black mage equips its corresponding weapons.
   */
  @Test
  void equipWeaponTest() {
    assertNull(testEngineer.getEquippedWeapon());
    testEngineer.equip(testAxe);
    assertEquals(testAxe, testEngineer.getEquippedWeapon());
    assertNotEquals(testBow, testEngineer.getEquippedWeapon());

    testEngineer.equip(testBow);
    assertEquals(testBow, testEngineer.getEquippedWeapon());
    assertNotEquals(testAxe, testEngineer.getEquippedWeapon());

    testEngineer.equip(testKnife);
    assertEquals(testBow, testEngineer.getEquippedWeapon());
    assertNotEquals(testKnife, testEngineer.getEquippedWeapon());

    testDeadEngineer.equip(testAxe);
    assertNull(testDeadEngineer.getEquippedWeapon());
    testDeadEngineer.equip(testBow);
    assertNull(testDeadEngineer.getEquippedWeapon());
  }

  /**
   * Checks if the attacks from an enemy to an engineer are correct.
   */
  @Test
  void attackTest() {
    assertEquals(100, testDefensiveEngineer.getCurrentLife());
    testEnemy.attack(testDefensiveEngineer);
    assertEquals(100, testDefensiveEngineer.getCurrentLife());

    assertEquals(100, testEngineer.getCurrentLife());
    testEnemy.attack(testEngineer);
    assertEquals(95, testEngineer.getCurrentLife());

    testDeadEnemy.attack(testEngineer);
    assertEquals(95, testEngineer.getCurrentLife());
  }
}
