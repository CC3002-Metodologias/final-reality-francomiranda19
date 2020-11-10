package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.classes.Engineer;
import com.github.francomiranda19.finalreality.model.character.player.classes.Knight;
import com.github.francomiranda19.finalreality.model.weapon.Axe;
import com.github.francomiranda19.finalreality.model.weapon.Knife;
import com.github.francomiranda19.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code Knight} class.
 *
 * @author Franco Miranda Oyarzún
 * @see Knight
 */
public class KnightTest extends AbstractCharacterTest {
  private static final String KNIGHT_NAME = "Test Knight";
  private Knight testKnight, testDefensiveKnight, testDeadKnight;
  private Enemy testEnemy, testDeadEnemy;
  private Sword testSword;
  private Axe testAxe;
  private Knife testKnife;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    testKnight = new Knight(KNIGHT_NAME, turns, LIFE, DEFENSE);
    testDefensiveKnight = new Knight("Test Defensive Knight", turns, LIFE, 80);
    testDeadKnight = new Knight("Test Dead Knight", turns, 0, DEFENSE);
    testEnemy = new Enemy("Test Enemy", 10, turns, LIFE, DEFENSE, 15);
    testDeadEnemy = new Enemy("Test Dead Enemy", 10, turns, 0, DEFENSE, 15);
    testSword = new Sword("Test Sword", 15, 10);
    testAxe = new Axe("Test Axe", 12, 10);
    testKnife = new Knife("Test Knife", 10, 10);
    super.basicSetUp();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var expectedKnight = new Knight(KNIGHT_NAME, turns, LIFE, DEFENSE);
    var otherWeaponKnight = new Knight(KNIGHT_NAME, turns, LIFE, DEFENSE);
    var notExpectedKnight1 = new Knight("Not Black Mage", turns, LIFE, DEFENSE);
    var notExpectedKnight2 = new Knight(KNIGHT_NAME, turns, LIFE + 1, DEFENSE);
    var notExpectedKnight3 = new Knight(KNIGHT_NAME, turns, LIFE, DEFENSE + 1);

    assertEquals(testKnight, testKnight);
    assertEquals(expectedKnight, testKnight);
    assertEquals(expectedKnight.hashCode(),testKnight.hashCode());
    otherWeaponKnight.equipAxe(testAxe);
    assertNotEquals(otherWeaponKnight, testKnight);
    assertNotEquals(otherWeaponKnight.hashCode(), testKnight.hashCode());
    assertNotEquals(notExpectedKnight1, testKnight);
    assertNotEquals(notExpectedKnight1.hashCode(), testKnight.hashCode());
    assertNotEquals(notExpectedKnight2, testKnight);
    assertNotEquals(notExpectedKnight2.hashCode(), testKnight.hashCode());
    assertNotEquals(notExpectedKnight3, testKnight);
    assertNotEquals(notExpectedKnight3.hashCode(), testKnight.hashCode());
    assertNotEquals(testKnight, new Engineer("Not Knight", turns, LIFE, DEFENSE));
  }

  /**
   * Checks if the knight equips a Sword.
   */
  @Test
  void equipSwordTest() {
    assertNull(testKnight.getEquippedWeapon());
    testKnight.equipSword(testSword);
    assertEquals(testSword, testKnight.getEquippedWeapon());
    assertNotEquals(testAxe, testKnight.getEquippedWeapon());
    assertNotEquals(testKnife, testKnight.getEquippedWeapon());

    testDeadKnight.equipSword(testSword);
    assertNull(testDeadKnight.getEquippedWeapon());
  }

  /**
   * Checks if the knight equips an Axe.
   */
  @Test
  void equipAxeTest() {
    testKnight.equipAxe(testAxe);
    assertEquals(testAxe, testKnight.getEquippedWeapon());
    assertNotEquals(testSword, testKnight.getEquippedWeapon());
    assertNotEquals(testKnife, testKnight.getEquippedWeapon());

    testDeadKnight.equipAxe(testAxe);
    assertNull(testDeadKnight.getEquippedWeapon());
  }

  /**
   * Checks if the knight equips a Knife.
   */
  @Test
  void equipKnifeTest() {
    testKnight.equipKnife(testKnife);
    assertEquals(testKnife, testKnight.getEquippedWeapon());
    assertNotEquals(testSword, testKnight.getEquippedWeapon());
    assertNotEquals(testAxe, testKnight.getEquippedWeapon());

    testDeadKnight.equipKnife(testKnife);
    assertNull(testDeadKnight.getEquippedWeapon());
  }

  /**
   * Checks if the attacks from an enemy to a knight are correct.
   */
  @Test
  void attackTest() {
    assertEquals(100, testDefensiveKnight.getCurrentLife());
    testEnemy.attack(testDefensiveKnight);
    assertEquals(100, testDefensiveKnight.getCurrentLife());

    assertEquals(100, testKnight.getCurrentLife());
    testEnemy.attack(testKnight);
    assertEquals(95, testKnight.getCurrentLife());

    testDeadEnemy.attack(testKnight);
    assertEquals(95, testKnight.getCurrentLife());
  }

}
