package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.character.player.Engineer;
import com.github.francomiranda19.finalreality.model.character.player.Thief;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Bow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code Engineer} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Engineer
 */
public class EngineerTest extends PlayerCharacterTest {
  private static final String ENGINEER_NAME = "Test Engineer";
  private Engineer testEngineer, testDefensiveEngineer, testDeadEngineer;
  private Enemy testEnemy, testDeadEnemy;
  private Axe testAxe;
  private Bow testBow;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testEngineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    testDefensiveEngineer = new Engineer("Test Defensive Engineer", turns, CharacterClass.ENGINEER, LIFE, 80);
    testDeadEngineer = new Engineer("Test Dead Engineer", turns, CharacterClass.ENGINEER, 0, DEFENSE);
    testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    testDeadEnemy = new Enemy("Test Dead Enemy", 10, turns, 0, DEFENSE, 15);
    testAxe = new Axe("Test Axe", 20, 10);
    testBow = new Bow("Test Bow", 25, 10);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedEngineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var otherWeaponEngineer = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var notExpectedEngineer1 = new Engineer("Not Engineer", turns, CharacterClass.ENGINEER, LIFE, DEFENSE);
    var notExpectedEngineer2 = new Engineer(ENGINEER_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE);
    var notExpectedEngineer3 = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE + 1, DEFENSE);
    var notExpectedEngineer4 = new Engineer(ENGINEER_NAME, turns, CharacterClass.ENGINEER, LIFE, DEFENSE + 1);

    assertEquals(testEngineer, testEngineer);
    assertEquals(expectedEngineer, testEngineer);
    assertEquals(expectedEngineer.hashCode(),testEngineer.hashCode());
    otherWeaponEngineer.equipAxe(testAxe);
    assertNotEquals(otherWeaponEngineer, testEngineer);
    assertNotEquals(otherWeaponEngineer.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer1, testEngineer);
    assertNotEquals(notExpectedEngineer1.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer2, testEngineer);
    assertNotEquals(notExpectedEngineer2.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer3, testEngineer);
    assertNotEquals(notExpectedEngineer3.hashCode(), testEngineer.hashCode());
    assertNotEquals(notExpectedEngineer4, testEngineer);
    assertNotEquals(notExpectedEngineer4.hashCode(), testEngineer.hashCode());
    assertNotEquals(testEngineer, new Thief("Not Engineer", turns, CharacterClass.ENGINEER, LIFE, DEFENSE));
  }

  /**
   * Checks if the engineer equips an Axe.
   */
  @Test
  void equipAxeTest() {
    assertNull(testEngineer.getEquippedWeapon());
    testEngineer.equipAxe(testAxe);
    assertEquals(testAxe, testEngineer.getEquippedWeapon());
    assertNotEquals(testBow, testEngineer.getEquippedWeapon());

    testDeadEngineer.equipAxe(testAxe);
    assertNull(testDeadEngineer.getEquippedWeapon());
  }

  /**
   * Checks if the engineer equips a Bow.
   */
  @Test
  void equipBowTest() {
    testEngineer.equipBow(testBow);
    assertEquals(testBow, testEngineer.getEquippedWeapon());
    assertNotEquals(testAxe, testEngineer.getEquippedWeapon());

    testDeadEngineer.equipBow(testBow);
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
